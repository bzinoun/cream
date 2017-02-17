'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('refSituationFamiliale', {
                parent: 'entity',
                url: '/refSituationFamiliales',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refSituationFamiliale.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refSituationFamiliale/refSituationFamiliales.html',
                        controller: 'RefSituationFamilialeController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refSituationFamiliale');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('refSituationFamiliale.detail', {
                parent: 'entity',
                url: '/refSituationFamiliale/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refSituationFamiliale.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refSituationFamiliale/refSituationFamiliale-detail.html',
                        controller: 'RefSituationFamilialeDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refSituationFamiliale');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'RefSituationFamiliale', function($stateParams, RefSituationFamiliale) {
                        return RefSituationFamiliale.get({id : $stateParams.id});
                    }]
                }
            })
            .state('refSituationFamiliale.new', {
                parent: 'refSituationFamiliale',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refSituationFamiliale/refSituationFamiliale-dialog.html',
                        controller: 'RefSituationFamilialeDialogController',
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
                        $state.go('refSituationFamiliale', null, { reload: true });
                    }, function() {
                        $state.go('refSituationFamiliale');
                    })
                }]
            })
            .state('refSituationFamiliale.edit', {
                parent: 'refSituationFamiliale',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refSituationFamiliale/refSituationFamiliale-dialog.html',
                        controller: 'RefSituationFamilialeDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['RefSituationFamiliale', function(RefSituationFamiliale) {
                                return RefSituationFamiliale.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refSituationFamiliale', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('refSituationFamiliale.delete', {
                parent: 'refSituationFamiliale',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refSituationFamiliale/refSituationFamiliale-delete-dialog.html',
                        controller: 'RefSituationFamilialeDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['RefSituationFamiliale', function(RefSituationFamiliale) {
                                return RefSituationFamiliale.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refSituationFamiliale', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
