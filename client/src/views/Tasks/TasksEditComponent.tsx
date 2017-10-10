import { StateSync } from '@state-sync/js-client';
import * as React from 'react';
import { connect, Dispatch } from 'react-redux';
import { Button, Card, CardBlock, CardFooter, CardHeader, FormGroup, Input, Label } from 'reactstrap';
import { State } from '../../store/index';
import { AREA_TASKS, TasksState } from '../../store/tasks';
import { SyncStateBind } from '../../utils/bind';
import { History, Location, Match, Routed, RoutedHistory, RoutedLocation, RoutedMatch } from '../../utils/routed';
import { SyntheticEvent } from "react";

const area = StateSync().area(AREA_TASKS);

interface RouteParams {
    taskId: string;
}

interface StateFromProps {
    tasks: TasksState;
}

interface DispatchFromProps {
    bindSummary: React.ChangeEventHandler<HTMLInputElement>;
    bindStatus: React.ChangeEventHandler<HTMLInputElement>;
}

interface CompProps extends StateFromProps, DispatchFromProps {
}

const mapStateToProps = (state: State) => {
    return {
        tasks: state.tasks
    };
};

const mapDispatchToProps = (dispatch: Dispatch<State>): DispatchFromProps => {
    return {
        bindSummary: SyncStateBind.bind(area, '/editTask/data/summary'),
        bindStatus: SyncStateBind.bind(area, '/editTask/data/status'),
    };
};

@Routed
class Comp extends React.Component<CompProps> {
    @RoutedMatch
    match: Match<RouteParams>;

    @RoutedLocation
    location: Location;

    @RoutedHistory
    history: History;

    constructor(props: CompProps) {
        super(props);
    }

    componentDidMount() {
        area.subscribe();
        // load
        area.signal('editTask', {id: this.match.params.taskId});
    }

    componentWillUnmount() {
        area.unsubscribe();
    }

    render() {
        const {tasks, bindSummary, bindStatus} = this.props;
        if (!tasks.editTask) {
            return (<span>loading...</span>);
        }
        const form = tasks.editTask.data;
        const saveTask = (e: SyntheticEvent<any>) => {
            e.preventDefault();
            area.signal('saveTask').then(() => {
                this.history.push('/task/list');
            });
        };
        return (
            <div className="container-fluid">
                <br/>
                <div className="animated fadeIn">
                    <div className="row">
                        <div className="col-12">
                            <form onSubmit={saveTask}>
                                <Card>
                                    <CardHeader>
                                        New task
                                    </CardHeader>
                                    <CardBlock>
                                        <FormGroup>
                                            <Label htmlFor="name">Summary</Label>
                                            <Input type="text" value={form.summary} placeholder="Summary" onChange={bindSummary}/>
                                        </FormGroup>
                                        <FormGroup tag="fieldset">
                                            <FormGroup check={true}>
                                                <Label check={true}>
                                                    <Input type="radio" value="New" checked={form.status === 'New'} onChange={bindStatus}/>
                                                    {' '}
                                                    New
                                                </Label>
                                                <Label check={true}>
                                                    <Input type="radio" value="InWork" checked={form.status === 'InWork'} onChange={bindStatus}/>
                                                    {' '}
                                                    InWork
                                                </Label>
                                                <Label check={true}>
                                                    <Input type="radio" value="Closed" checked={form.status === 'Closed'} onChange={bindStatus}/>
                                                    {' '}
                                                    Closed
                                                </Label>
                                            </FormGroup>
                                        </FormGroup>
                                    </CardBlock>
                                    <CardFooter>
                                        <Button type="submit" onClick={saveTask}>Save</Button>
                                    </CardFooter>
                                </Card>
                            </form>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-12">
                            <Card>
                                <CardHeader>
                                    Area model
                                </CardHeader>
                                <CardBlock>
                                    <pre>{JSON.stringify(tasks, null, 2)};</pre>
                                </CardBlock>
                            </Card>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

const TasksEditComponent = connect<StateFromProps, DispatchFromProps>(mapStateToProps, mapDispatchToProps)(Comp);

export default TasksEditComponent;
