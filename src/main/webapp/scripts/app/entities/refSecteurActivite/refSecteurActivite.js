'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('refSecteurActivite', {
                parent: 'entity',
                url: '/refSecteurActivites',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refSecteurActivite.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refSecteurActivite/refSecteurActivites.html',
                        controller: 'RefSecteurActiviteController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refSecteurActivite');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('refSecteurActivite.detail', {
                parent: 'entity',
                url: '/refSecteurActivite/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refSecteurActivite.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refSecteurActivite/refSecteurActivite-detail.html',
                        controller: 'RefSecteurActiviteDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refSecteurActivite');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'RefSecteurActivite', function($stateParams, RefSecteurActivite) {
                        return RefSecteurActivite.get({id : $stateParams.id});
                    }]
                }
            })
            .state('refSecteurActivite.new', {
                parent: 'refSecteurActivite',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refSecteurActivite/refSecteurActivite-dialog.html',
                        controller: 'RefSecteurActiviteDialogController',
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
                        $state.go('refSecteurActivite', null, { reload: true });
                    }, function() {
                        $state.go('refSecteurActivite');
                    })
                }]
            })
            .state('refSecteurActivite.edit', {
                parent: 'refSecteurActivite',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refSecteurActivite/refSecteurActivite-dialog.html',
                        controller: 'RefSecteurActiviteDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['RefSecteurActivite', function(RefSecteurActivite) {
                                return RefSecteurActivite.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refSecteurActivite', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('refSecteurActivite.delete', {
                parent: 'refSecteurActivite',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refSecteurActivite/refSecteurActivite-delete-dialog.html',
                        controller: 'RefSecteurActiviteDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['RefSecteurActivite', function(RefSecteurActivite) {
                                return RefSecteurActivite.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refSecteurActivite', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
