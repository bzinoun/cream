'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
                     .state('calendar', {
                parent: 'site',
                url: '/calendar',
                data: {
                    authorities: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/components/calendar/calendar.html',
                        controller: 'CalendarController'
                    }
                },
                resolve: {
                    mainTranslatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                        $translatePartialLoader.addPart('main');
                        $translatePartialLoader.addPart('tache');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })   
            
            
                        .state('calendar.tache_edit', {
                parent: 'calendar',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/tache/tache-dialog.html',
                        controller: 'TacheDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Tache', function(Tache) {
                                return Tache.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('calendar', null, { reload: true });
                    }, function() {
                        $state.go('calendar');
                    })
                }]
            })
            
            ;
        
        
        
    });
