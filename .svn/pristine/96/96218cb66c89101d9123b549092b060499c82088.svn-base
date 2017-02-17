'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('action', {
                parent: 'entity',
                url: '/actions',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.action.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/action/actions.html',
                        controller: 'ActionController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('action');
                        $translatePartialLoader.addPart('typeAction');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('action.detail', {
                parent: 'entity',
                url: '/action/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.action.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/action/action-detail.html',
                        controller: 'ActionDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('action');
                        $translatePartialLoader.addPart('typeAction');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Action', function($stateParams, Action) {
                        return Action.get({id : $stateParams.id});
                    }]
                }
            })
            .state('action.new', {
                parent: 'action',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/action/action-dialog.html',
                        controller: 'ActionDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    sujet: null,
                                    description: null,
                                    dateDebut: null,
                                    dateFin: null,
                                    typeAction: null,
                                    user: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('action', null, { reload: true });
                    }, function() {
                        $state.go('action');
                    })
                }]
            })
            .state('action.edit', {
                parent: 'action',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/action/action-dialog.html',
                        controller: 'ActionDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Action', function(Action) {
                                return Action.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('action', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('action.delete', {
                parent: 'action',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/action/action-delete-dialog.html',
                        controller: 'ActionDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Action', function(Action) {
                                return Action.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('action', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
