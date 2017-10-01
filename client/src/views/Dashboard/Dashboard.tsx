import * as React from 'react';
import { connect, Dispatch } from 'react-redux';
import { Line } from 'react-chartjs-2';
import {
    Row,
    Col,
    Card,
    CardBlock,
    Button,
} from 'reactstrap';
import chart1Options from './chart1Options';
import { State } from '../../store/index';
import { StateSync } from '@state-sync/js-client';

const mapStateToProps = (state: State) => {
    return {
        dashboard: JSON.parse(JSON.stringify(state.dashboard))
    };
}

const mapDispatchToProps = (dispatch: Dispatch<State>) => {
    return {
        onTodoClick: (id: string) => {
            StateSync().actionToggle('dashboard', '/settings/watch');
        }
    };
}

const DashboardRender = ({ dashboard: DashboardState, onTodoClick: any}) => {
    let chart1 = dashboard.chart1 ? <div className="chart-wrapper px-3" style={{height: '70px'}}>
        <Line data={dashboard.chart1.data} options={chart1Options} height={70}/>
    </div> : '';

    return (
        <div className="animated fadeIn">
            <Row>
                <Col xs="12" sm="6" lg="3">
                    <Card className="text-white bg-primary">
                        <CardBlock className="card-body pb-0">
                            <h4 className="mb-0">9.823</h4>
                            <p>Members online</p>
                        </CardBlock>
                        {chart1}
                    </Card>
                </Col>
            </Row>
            <h1>{dashboard.name}</h1>
            <br/>
            <Button onClick={onTodoClick}>Toggle counter</Button>
            <ul>
                <li>Trucks count - {dashboard.trucksCount} </li>
                <li>Profit - {dashboard.profit} </li>
            </ul>
        </div>
    );
};

const Dashboard = connect(
    mapStateToProps,
    mapDispatchToProps
)(DashboardRender)

export default Dashboard;
