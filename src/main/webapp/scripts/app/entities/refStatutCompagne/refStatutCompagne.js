'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('refStatutCompagne', {
                parent: 'entity',
                url: '/refStatutCompagnes',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refStatutCompagne.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refStatutCompagne/refStatutCompagnes.html',
                        controller: 'RefStatutCompagneController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refStatutCompagne');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('refStatutCompagne.detail', {
                parent: 'entity',
                url: '/refStatutCompagne/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refStatutCompagne.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refStatutCompagne/refStatutCompagne-detail.html',
                        controller: 'RefStatutCompagneDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refStatutCompagne');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'RefStatutCompagne', function($stateParams, RefStatutCompagne) {
                        return RefStatutCompagne.get({id : $stateParams.id});
                    }]
                }
            })
            .state('refStatutCompagne.new', {
                parent: 'refStatutCompagne',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutCompagne/refStatutCompagne-dialog.html',
                        controller: 'RefStatutCompagneDialogController',
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
                        $state.go('refStatutCompagne', null, { reload: true });
                    }, function() {
                        $state.go('refStatutCompagne');
                    })
                }]
            })
            .state('refStatutCompagne.edit', {
                parent: 'refStatutCompagne',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutCompagne/refStatutCompagne-dialog.html',
                        controller: 'RefStatutCompagneDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['RefStatutCompagne', function(RefStatutCompagne) {
                                return RefStatutCompagne.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refStatutCompagne', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('refStatutCompagne.delete', {
                parent: 'refStatutCompagne',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutCompagne/refStatutCompagne-delete-dialog.html',
                        controller: 'RefStatutCompagneDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['RefStatutCompagne', function(RefStatutCompagne) {
                                return RefStatutCompagne.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refStatutCompagne', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
