'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('compagne', {
                parent: 'entity',
                url: '/compagnes',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.compagne.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/compagne/compagnes.html',
                        controller: 'CompagneController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('compagne');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('compagne.detail', {
                parent: 'entity',
                url: '/compagne/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.compagne.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/compagne/compagne-detail.html',
                        controller: 'CompagneDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('compagne');
                        $translatePartialLoader.addPart('personne');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Compagne', function($stateParams, Compagne) {
                        return Compagne.get({id : $stateParams.id}).$promise;
                    }]
                }
            })
            .state('compagne.new', {
                parent: 'compagne',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/compagne/compagne-dialog.html',
                        controller: 'CompagneDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    libelle: null,
                                    dateDebut: null,
                                    dateFin: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('compagne', null, { reload: true });
                    }, function() {
                        $state.go('compagne');
                    })
                }]
            })
            .state('compagne.edit', {
                parent: 'compagne',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/compagne/compagne-dialog.html',
                        controller: 'CompagneDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Compagne', function(Compagne) {
                                return Compagne.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('compagne', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('compagne.delete', {
                parent: 'compagne',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/compagne/compagne-delete-dialog.html',
                        controller: 'CompagneDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Compagne', function(Compagne) {
                                return Compagne.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('compagne', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
