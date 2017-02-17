'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('refStatutProspection', {
                parent: 'entity',
                url: '/refStatutProspections',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refStatutProspection.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refStatutProspection/refStatutProspections.html',
                        controller: 'RefStatutProspectionController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refStatutProspection');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('refStatutProspection.detail', {
                parent: 'entity',
                url: '/refStatutProspection/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.refStatutProspection.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/refStatutProspection/refStatutProspection-detail.html',
                        controller: 'RefStatutProspectionDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('refStatutProspection');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'RefStatutProspection', function($stateParams, RefStatutProspection) {
                        return RefStatutProspection.get({id : $stateParams.id});
                    }]
                }
            })
            .state('refStatutProspection.new', {
                parent: 'refStatutProspection',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutProspection/refStatutProspection-dialog.html',
                        controller: 'RefStatutProspectionDialogController',
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
                        $state.go('refStatutProspection', null, { reload: true });
                    }, function() {
                        $state.go('refStatutProspection');
                    })
                }]
            })
            .state('refStatutProspection.edit', {
                parent: 'refStatutProspection',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutProspection/refStatutProspection-dialog.html',
                        controller: 'RefStatutProspectionDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['RefStatutProspection', function(RefStatutProspection) {
                                return RefStatutProspection.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refStatutProspection', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('refStatutProspection.delete', {
                parent: 'refStatutProspection',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/refStatutProspection/refStatutProspection-delete-dialog.html',
                        controller: 'RefStatutProspectionDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['RefStatutProspection', function(RefStatutProspection) {
                                return RefStatutProspection.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('refStatutProspection', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
