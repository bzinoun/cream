'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('tache', {
                parent: 'entity',
                url: '/taches',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.tache.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/tache/taches.html',
                        controller: 'TacheController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('tache');
                        $translatePartialLoader.addPart('typeTache');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('tache.detail', {
                parent: 'entity',
                url: '/tache/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.tache.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/tache/tache-detail.html',
                        controller: 'TacheDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('tache');
                        $translatePartialLoader.addPart('typeTache');
                        $translatePartialLoader.addPart('action');
                        $translatePartialLoader.addPart('typeAction');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Tache', function($stateParams, Tache) {
                        return Tache.get({id : $stateParams.id});
                    }]
                }
            })
            .state('tache.new', {
                parent: 'tache',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/tache/tache-dialog.html',
                        controller: 'TacheDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    sujet: null,
                                    description: null,
                                    dateDebut: null,
                                    dateFin: null,
                                    type: null,
                                    pieceJointe: null,
                                    pieceJointeContentType: null,
                                    user: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('tache', null, { reload: true });
                    }, function() {
                        $state.go('tache');
                    })
                }]
            })
            .state('tache.edit', {
                parent: 'tache',
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
                        $state.go('tache', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('tache.delete', {
                parent: 'tache',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/tache/tache-delete-dialog.html',
                        controller: 'TacheDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Tache', function(Tache) {
                                return Tache.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('tache', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })

            .state('tache.detail.action_new', {
                parent: 'tache.detail',
                url: '/action/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/tache/action-dialog.html',
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
                                    id: null,
                                    tacheId : parseInt($stateParams.id )
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('tache', null, { reload: true });
                    }, function() {
                        $state.go('tache');
                    })
                }]
            })
            ;
    });
