import { StateSync } from '@state-sync/js-client';
import * as React from 'react';
import { connect, Dispatch } from 'react-redux';
import { Table } from 'reactstrap';
import { State } from '../../store/index';
import { AREA_TABLE, TableState } from '../../store/table';

const area = StateSync().area(AREA_TABLE);

interface StateFromProps {
    table: TableState;
}

interface DispatchFromProps {
}

interface MyProps extends StateFromProps, DispatchFromProps {
}

const mapStateToProps = (state: State) => {
    return {
        table: JSON.parse(JSON.stringify(state.table))
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
    }

    componentWillUnmount() {
        area.unsubscribe();
    }

    render() {
        const {table} = this.props;
        let rows = table.items.data.map((item, index: number) => {
                let data = item.data;
                return (
                    <tr key={data.id}>
                        <td>{data.id}</td>
                        <td>{data.name}</td>
                        <td>{data.status}</td>
                    </tr>
                );
            }
        );

        return (
            <div className="animated fadeIn">
                <Table>
                    <thead>
                    <tr>
                        <th onClick={(e) => area.actionReplace('/query/sortBy', 'id')}>id</th>
                        <th onClick={(e) => area.actionReplace('/query/sortBy', 'name')}>name</th>
                        <th onClick={(e) => area.actionReplace('/query/sortBy', 'status')}>status</th>
                    </tr>
                    </thead>
                    <tbody>
                    {rows}
                    </tbody>
                </Table>
                <pre>
                    {JSON.stringify(table, null, 2)};
                </pre>
            </div>
        );
    }
}

const TableExample
    = connect<StateFromProps, DispatchFromProps>(mapStateToProps, mapDispatchToProps)(DashboardComponent);

export default TableExample;
