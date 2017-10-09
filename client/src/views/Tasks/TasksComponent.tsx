import { StateSync } from '@state-sync/js-client';
import * as React from 'react';
import { connect, Dispatch } from 'react-redux';
import { Button, FormGroup, Label, Card, CardBlock, CardFooter, CardHeader, Input, Pagination, PaginationLink, Table } from 'reactstrap';
import { ColSortIcon } from '../../components/Table/ColSortIcon';
import { State } from '../../store/index';
import { AREA_TASKS, TasksState } from '../../store/tasks';
import { SyncStateBind } from '../../utils/bind';
import { SetSort } from '../../models/ItemListQuery';

const area = StateSync().area(AREA_TASKS);

interface StateFromProps {
    tasks: TasksState;
}

interface DispatchFromProps {
    bindSearch: React.ChangeEventHandler<HTMLInputElement>;
    bindNewTaskSummary: React.ChangeEventHandler<HTMLInputElement>;
    createTask: React.MouseEventHandler<HTMLElement>;
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
        bindSearch: SyncStateBind.bind(area, '/query/search'),
        bindNewTaskSummary: SyncStateBind.bind(area, '/newTask/summary'),
        createTask: SyncStateBind.signal(area, 'createTask')
    };
};

class Comp extends React.Component<CompProps> {
    componentDidMount() {
        area.subscribe();
    }

    componentWillUnmount() {
        area.unsubscribe();
    }

    render() {
        const {tasks, bindSearch, bindNewTaskSummary, createTask} = this.props;
        const query = tasks.query;
        const newTask = tasks.newTask;
        const sort = (col: string) => (e: React.MouseEvent<HTMLElement>): void => {
            area.actionReduce('/query', SetSort(col));
        };

        let rows = tasks.items.data.map((item, index: number) => {
                let data = item.data;
                return (
                    <tr key={data.id}>
                        <td>{data.id}</td>
                        <td>{data.summary}</td>
                        <td>{data.status}</td>
                    </tr>
                );
            }
        );

        return (
            <div className="container-fluid">
                <br/>
                <div className="animated fadeIn">
                    <div className="row">
                        <div className="col-8">
                            <Card>
                                <CardHeader>
                                    <div className="row">
                                        <div className="col-8">Tasks</div>
                                        <div className="col-4">
                                            <Input value={query.search} onChange={bindSearch}/>
                                        </div>
                                    </div>
                                </CardHeader>
                                <CardBlock>
                                    <Table>
                                        <thead>
                                        <tr>
                                            <th className="gridHeader" onClick={sort('id')}>id
                                                <ColSortIcon query={query} forId="id"/>
                                            </th>
                                            <th className="gridHeader" onClick={sort('summary')}>
                                                summary
                                                <ColSortIcon query={query} forId="summary"/>
                                            </th>
                                            <th className="gridHeader" onClick={sort('status')}>
                                                status
                                                <ColSortIcon query={query} forId="status"/>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        {rows}
                                        </tbody>
                                    </Table>
                                </CardBlock>
                                <CardFooter>
                                    <Pagination>
                                        <PaginationLink>#</PaginationLink>
                                    </Pagination>
                                </CardFooter>
                            </Card>
                        </div>
                        <div className="col-4">
                            <Card>
                                <CardHeader>
                                    New task
                                </CardHeader>
                                <CardBlock>
                                    <FormGroup>
                                        <Label htmlFor="name">Summary</Label>
                                        <Input type="text" value={newTask.summary} id="name" placeholder="Summary" onChange={bindNewTaskSummary}/>
                                    </FormGroup>
                                </CardBlock>
                                <CardFooter>
                                    <Button onClick={createTask}>Create</Button>
                                </CardFooter>
                            </Card>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-4">
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

const TasksComponent
    = connect
    < StateFromProps, DispatchFromProps
>
(mapStateToProps, mapDispatchToProps)(Comp);

export default TasksComponent;
