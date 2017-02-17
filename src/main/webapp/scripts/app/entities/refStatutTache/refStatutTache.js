'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('refStatutTache', {
                parent: 'entity',
                url: '/refStatutTaches',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refStatutTache.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refStatutTache/refStatutTaches.html',
                        controller: 'RefStatutTacheController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refStatutTache');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('refStatutTache.detail', {
                parent: 'entity',
                url: '/refStatutTache/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refStatutTache.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refStatutTache/refStatutTache-detail.html',
                        controller: 'RefStatutTacheDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refStatutTache');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'RefStatutTache', function($stateParams, RefStatutTache) {
                        return RefStatutTache.get({id : $stateParams.id});
                    }]
                }
            })
            .state('refStatutTache.new', {
                parent: 'refStatutTache',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutTache/refStatutTache-dialog.html',
                        controller: 'RefStatutTacheDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    code: null,
                                    libelle: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('refStatutTache', null, { reload: true });
                    }, function() {
                        $state.go('refStatutTache');
                    })
                }]
            })
            .state('refStatutTache.edit', {
                parent: 'refStatutTache',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutTache/refStatutTache-dialog.html',
                        controller: 'RefStatutTacheDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['RefStatutTache', function(RefStatutTache) {
                                return RefStatutTache.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refStatutTache', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('refStatutTache.delete', {
                parent: 'refStatutTache',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutTache/refStatutTache-delete-dialog.html',
                        controller: 'RefStatutTacheDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['RefStatutTache', function(RefStatutTache) {
                                return RefStatutTache.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refStatutTache', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
