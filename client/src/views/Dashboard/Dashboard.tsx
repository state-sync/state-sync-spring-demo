import { StateSync } from '@state-sync/js-client';
import * as React from 'react';
import { Line } from 'react-chartjs-2';
import { connect, Dispatch } from 'react-redux';
import { Button, Card, CardBlock, CardFooter, Col, Row } from 'reactstrap';
import { AREA_DASHBOARD, DashboardState } from '../../store/dashboard';
import { AREA_DEBUG, DebugState } from '../../store/debug';
import { State } from '../../store/index';
import chart1Options from './chart1Options';

const area = StateSync().area(AREA_DASHBOARD);
const debugArea = StateSync().area(AREA_DEBUG);

interface StateFromProps {
    dashboard: DashboardState;
    debug: DebugState;
}

interface DispatchFromProps {
    handleClick: () => void;
}

interface MyProps extends StateFromProps, DispatchFromProps {
}

const mapStateToProps = (state: State) => {
    return {
        dashboard: JSON.parse(JSON.stringify(state.dashboard)),
        debug: JSON.parse(JSON.stringify(state.debug))
    };
};

const mapDispatchToProps = (dispatch: Dispatch<State>): DispatchFromProps => {
    return {
        handleClick: () => {
            area.actionToggle('/settings/watch');
        }
    };
};

class DashboardComponent extends React.Component<MyProps> {
    componentDidMount() {
        area.subscribe();
        debugArea.subscribe();
    }

    componentWillUnmount() {
        area.unsubscribe();
    }

    render() {
        const {dashboard, debug, handleClick} = this.props;
        const watchLabel = dashboard.settings.watch ? 'Unwatch' : 'Watch';
        
        let chart1 = dashboard.chart1 ? (
            <div className="chart-wrapper px-3" style={{height: '70px'}}>
                <Line data={dashboard.chart1.data} options={chart1Options} height={70}/>
            </div>
        ) : '';

        return (
            <div className="animated fadeIn">
                <Row>
                    <Col xs="12" sm="6" lg="3">
                        <Card className="text-white bg-primary">
                            <CardBlock className="card-body pb-0">
                                <h4 className="mb-0">{dashboard.membersOnline}</h4>
                                <p>Members online</p>
                            </CardBlock>
                            {chart1}
                        </Card>
                        <CardFooter>
                            <Button onClick={() => handleClick()}>{watchLabel}</Button>
                        </CardFooter>
                    </Col>
                </Row>
                <h1>{dashboard.name}</h1>
                <br/>
                <pre>
                    {JSON.stringify(debug, null, 2)};
                </pre>
            </div>
        );
    }
}

const Dashboard = connect<StateFromProps, DispatchFromProps>(mapStateToProps, mapDispatchToProps)(DashboardComponent);

export default Dashboard;
