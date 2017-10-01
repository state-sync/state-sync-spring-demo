export interface Wrapper {
    element: string;        // required valid HTML5 element tag
    attributes: object;
}

export interface BadgeDef {
    class: string;
    variant: 'info' | 'warning';
    text: string;
}

export interface NavItemDef {

    class?: string;
    badge?: BadgeDef;
    divider?: boolean;
    title?: string;
    name?: string;
    icon?: string;
    url: string;
    children?: NavItemDef[];
    wrapper?: Wrapper;
}