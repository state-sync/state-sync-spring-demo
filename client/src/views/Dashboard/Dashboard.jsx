import React from 'react';
import { connect } from 'react-redux';
import {Bar, Line} from "react-chartjs-2";
import {
    Badge,
    Row,
    Col,
    Progress,
    Dropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
    Card,
    CardHeader,
    CardBlock,
    CardFooter,
    CardTitle,
    Button,
    ButtonToolbar,
    ButtonGroup,
    ButtonDropdown,
    Label,
    Input,
    Table
} from "reactstrap";
import chart1Options from './chart1Options';
import { dashboardToggleWatch } from '../../store/actions.js'
import { actionAreaToggle } from "../../store/middleware/store-sync";

const mapStateToProps = state => {
    return {
        dashboard: JSON.parse(JSON.stringify(state.dashboard))
    }
}

const mapDispatchToProps = dispatch => {
    return {
        onTodoClick: id => {
            actionAreaToggle('dashboard', '/settings/watch');
        }
    }
}

const DashboardRender = ({dashboard, onTodoClick}) => {
    let chart1 = dashboard.chart1 ? <div className="chart-wrapper px-3" style={{height:'70px'}}>
        <Line data={dashboard.chart1.data} options={chart1Options} height={70}/>
    </div> : '';

    return (
        <div className="animated fadeIn">
            <Row>
                <Col xs="12" sm="6" lg="3">
                    <Card className="text-white bg-primary">
                        <CardBlock className="card-body pb-0">
                            {/*<ButtonGroup className="float-right">*/}
                                {/*<ButtonDropdown id='card1' isOpen={this.state.card1}*/}
                                                {/*toggle={() => { this.setState({ card1: !this.state.card1 }); }}>*/}
                                    {/*<DropdownToggle caret className="p-0" color="transparent">*/}
                                        {/*<i className="icon-settings"></i>*/}
                                    {/*</DropdownToggle>*/}
                                    {/*<DropdownMenu className={this.state.card1 ? "show" : ""} right>*/}
                                        {/*<DropdownItem>Action</DropdownItem>*/}
                                        {/*<DropdownItem>Another action</DropdownItem>*/}
                                        {/*<DropdownItem disabled>Disabled action</DropdownItem>*/}
                                        {/*<DropdownItem>Something else here</DropdownItem>*/}
                                    {/*</DropdownMenu>*/}
                                {/*</ButtonDropdown>*/}
                            {/*</ButtonGroup>*/}
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
    )
};

const Dashboard = connect(
    mapStateToProps,
    mapDispatchToProps
)(DashboardRender)

export default Dashboard
