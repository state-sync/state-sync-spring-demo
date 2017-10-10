import { ISyncArea } from '@state-sync/js-client';
import * as React from 'react';
import { SyntheticEvent } from 'react';

export class SyncStateBind {
    static bind(area: ISyncArea, path: string): React.ChangeEventHandler<HTMLInputElement> {
        return (e: React.ChangeEvent<HTMLInputElement>) => area.actionReplace(path, e.target.value);
    }

    static signal(area: ISyncArea, signal: string, then?: any): any {
        return (e: SyntheticEvent<any>) => {
            const promise = area.signal(signal, {});
            if (then) {
                promise.then((e) => then(e));
            }
            e.preventDefault();
        };
    }
}