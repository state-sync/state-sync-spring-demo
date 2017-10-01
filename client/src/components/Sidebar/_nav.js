export default {
    items: [
        {
            name: 'Dashboard',
            url: '/dashboard',
            icon: 'icon-speedometer',
            badge: {
                variant: 'info',
                text: 'NEW'
            }
        },
        {
            title: true,
            name: 'Schedule',
            wrapper: {            // optional wrapper object
                element: '',        // required valid HTML5 element tag
                attributes: {}        // optional valid JS object with JS API naming ex: { className: "my-class", style: { fontFamily: "Verdana" }, id: "my-id"}
            },
            class: ''             // optional class names space delimited list for title item ex: "text-center"
        },
        {
            name: 'Calendar',
            url: '/schedule/calendar',
            icon: 'icon-calendar'
        },
        {
            name: 'Schedules',
            url: '/schedule/schedules',
            icon: 'icon-layers'
        },
        {
            name: 'Timetables',
            url: '/schedule/timetables',
            icon: 'icon-cursor'
        },
        {
            name: 'Demo',
            url: '/timetable',
            icon: 'icon-cursor'
        },
        {
            title: true,
            name: 'Trucks',
            wrapper: {            // optional wrapper object
                element: '',        // required valid HTML5 element tag
                attributes: {}        // optional valid JS object with JS API naming ex: { className: "my-class", style: { fontFamily: "Verdana" }, id: "my-id"}
            },
            class: ''             // optional class names space delimited list for title item ex: "text-center"
        },
        {
            name: 'Status',
            url: '/trucks/status',
            icon: 'icon-speedometer'
        },
        {
            name: 'Manage',
            url: '/trucks/list',
            icon: 'icon-cursor'
        }

    ]
};
