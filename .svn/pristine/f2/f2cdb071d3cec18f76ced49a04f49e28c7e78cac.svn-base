'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('personne', {
                parent: 'entity',
                url: '/personnes',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.personne.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/personne/personnes.html',
                        controller: 'PersonneController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('personne');
                        $translatePartialLoader.addPart('typePersonne');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('personne.detail', {
                parent: 'entity',
                url: '/personne/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.personne.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/personne/personne-detail.html',
                        controller: 'PersonneDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('personne');
                        $translatePartialLoader.addPart('typePersonne');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Personne', function($stateParams, Personne) {
                        return Personne.get({id : $stateParams.id});
                    }]
                }
            })
            .state('personne.new', {
                parent: 'personne',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/personne/personne-dialog.html',
                        controller: 'PersonneDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    nom: null,
                                    numeroCIN: null,
                                    rc: null,
                                    telephone: null,
                                    prenom: null,
                                    civilite: null,
                                    type: null,
                                    titre: null,
                                    dateNaissance: null,
                                    numeroPatente: null,
                                    raisonSociale: null,
                                    email: null,
                                    ville: null,
                                    dateObtentionPermis: null,
                                    numeroPermis: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('personne', null, { reload: true });
                    }, function() {
                        $state.go('personne');
                    })
                }]
            })
            .state('personne.edit', {
                parent: 'prospection.edit',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/personne/personne-dialog.html',
                        controller: 'PersonneDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Personne', function(Personne) {
                                return Personne.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('personne', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })

            .state('personne.delete', {
                parent: 'personne',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/personne/personne-delete-dialog.html',
                        controller: 'PersonneDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Personne', function(Personne) {
                                return Personne.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('personne', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
