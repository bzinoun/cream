'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('perference', {
                parent: 'entity',
                url: '/perferences',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.perference.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/perference/perferences.html',
                        controller: 'PerferenceController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('perference');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('perference.detail', {
                parent: 'entity',
                url: '/perference/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.perference.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/perference/perference-detail.html',
                        controller: 'PerferenceDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('perference');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Perference', function($stateParams, Perference) {
                        return Perference.get({id : $stateParams.id});
                    }]
                }
            })
            .state('perference.new', {
                parent: 'perference',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/perference/perference-dialog.html',
                        controller: 'PerferenceDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    sujet: null,
                                    description: null,
                                    dateImport: null,
                                    pieceJointe: null,
                                    pieceJointeContentType: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('perference', null, { reload: true });
                    }, function() {
                        $state.go('perference');
                    })
                }]
            })
            .state('perference.edit', {
                parent: 'perference',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/perference/perference-dialog.html',
                        controller: 'PerferenceDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Perference', function(Perference) {
                                return Perference.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('perference', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('perference.delete', {
                parent: 'perference',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/perference/perference-delete-dialog.html',
                        controller: 'PerferenceDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Perference', function(Perference) {
                                return Perference.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('perference', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
