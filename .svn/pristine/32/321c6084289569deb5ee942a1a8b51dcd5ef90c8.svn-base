'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
                     .state('setting', {
                parent: 'site',
                url: '/settings',
                data: {
                    authorities: ['ROLE_ADMIN']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/components/setting/setting.html',
                        controller: 'SettingController'
                    }
                },
                resolve: {
                    mainTranslatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                        $translatePartialLoader.addPart('main');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })   
            
            ;
        
        
        
    });
