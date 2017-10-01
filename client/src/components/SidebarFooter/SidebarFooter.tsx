import * as React from 'react';
import { connect, Dispatch } from 'react-redux';
import './style.css';
import { State } from '../../store/index';

interface StateFromProps {
}

interface DispatchFromProps {
    handleClick: () => void;
}

interface MyProps extends StateFromProps, DispatchFromProps {
}

const mapStateToProps = (state: State) => {
    return {
        // status: state.syncStatus,
       // sync: R.pipe(R.values, R.map(a=>a.sync), R.reduce((a,b)=>a && b, true))(state.syncStatus.areas)
    };
};

const mapDispatchToProps = (dispatch: Dispatch<State>) => {
    return {};
};

class SidebarFooterRender extends React.Component<MyProps> {
    render() {
        // debugger;
        return (
            <div className="sidebar-footer">
                {/*<div className={'connection-status ' + status.connection}>{status.connection}</div>*/}
                {/*<div className={'sync-status ' + sync}>Syncing</div>*/}
            </div>
        );
    }
}

const SidebarFooter = connect(mapStateToProps, mapDispatchToProps)(SidebarFooterRender);

export default SidebarFooter;
