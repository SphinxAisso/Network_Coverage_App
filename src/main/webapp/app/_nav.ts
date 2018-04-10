export const navigation = [
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
        name: 'Theme'
    },
    {
        name: 'Colors',
        url: '/theme/colors',
        icon: 'icon-drop'
    },
    {
        name: 'Typography',
        url: '/theme/typography',
        icon: 'icon-pencil'
    },
    {
        title: true,
        name: 'Components'
    },
    {
        name: 'Base',
        url: '/base',
        icon: 'icon-puzzle',
        children: [
            {
                name: 'Cards',
                url: '/base/cards',
                icon: 'icon-puzzle'
            },
            {
                name: 'Carousels',
                url: '/base/carousels',
                icon: 'icon-puzzle'
            },
            {
                name: 'Collapses',
                url: '/base/collapses',
                icon: 'icon-puzzle'
            },
            {
                name: 'Forms',
                url: '/base/forms',
                icon: 'icon-puzzle'
            },
            {
                name: 'Pagination',
                url: '/base/paginations',
                icon: 'icon-puzzle'
            },
            {
                name: 'Popovers',
                url: '/base/popovers',
                icon: 'icon-puzzle'
            },
            {
                name: 'Progress',
                url: '/base/progress',
                icon: 'icon-puzzle'
            },
            {
                name: 'Switches',
                url: '/base/switches',
                icon: 'icon-puzzle'
            },
            {
                name: 'Tables',
                url: '/base/tables',
                icon: 'icon-puzzle'
            },
            {
                name: 'Tabs',
                url: '/base/tabs',
                icon: 'icon-puzzle'
            },
            {
                name: 'Tooltips',
                url: '/base/tooltips',
                icon: 'icon-puzzle'
            }
        ]
    }
];
