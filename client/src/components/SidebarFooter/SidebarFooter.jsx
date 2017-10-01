import React from 'react';
import { connect } from "react-redux";
import './style.css'
import R from 'rambdax';

const mapStateToProps = state => {
    return {
        status: state.syncStatus,
        sync: R.pipe(R.values, R.map(a=>a.sync), R.reduce((a,b)=>a && b, true))(state.syncStatus.areas)
    }
}

const mapDispatchToProps = dispatch => {
    return {}
}

function SidebarFooterRender({status, sync}) {
    // debugger;
    return (
        <div className="sidebar-footer">
            <div className={'connection-status ' + status.connection}>{status.connection}</div>
            <div className={'sync-status ' + sync}>Syncing</div>
        </div>
    )
}

const SidebarFooter = connect(
    mapStateToProps,
    mapDispatchToProps
)(SidebarFooterRender)

export default SidebarFooter;
