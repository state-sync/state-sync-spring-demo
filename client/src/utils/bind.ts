import { ISyncArea } from '@state-sync/js-client';
import * as React from 'react';
import { SyntheticEvent } from 'react';

export class SyncStateBind {
    static bind(area: ISyncArea, path: string): React.ChangeEventHandler<HTMLInputElement> {
        return (e: React.ChangeEvent<HTMLInputElement>) => area.actionReplace(path, e.target.value);
    }

    static signal(area: ISyncArea, signal: string): any {
        return (e: SyntheticEvent<any>) => {
            area.signal(signal, {});
            e.preventDefault();
        };
    }
}