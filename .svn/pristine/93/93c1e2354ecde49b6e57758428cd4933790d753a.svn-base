'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('prospection', {
                parent: 'entity',
                url: '/prospections',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.prospection.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/prospection/prospections.html',
                        controller: 'ProspectionController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('prospection');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            
            .state('prospection.detail', {
                parent: 'entity',
                url: '/prospection/{id}?tacheId',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'creamApp.prospection.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/prospection/prospection-detail.html',
                        controller: 'ProspectionDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('prospection');
                        $translatePartialLoader.addPart('action');
                        $translatePartialLoader.addPart('compagne');
                        $translatePartialLoader.addPart('personne');
                        $translatePartialLoader.addPart('tache');
                        $translatePartialLoader.addPart('typeTache');
            			$translatePartialLoader.addPart('typeAction');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Prospection', function($stateParams, Prospection) {
                        return Prospection.get({id : $stateParams.id}).$promise;
                    }]
                }
            })

            .state('prospection.new', {
                parent: 'prospection',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/prospection/prospection-dialog.html',
                        controller: 'ProspectionDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    sujet: null,
                                    description: null,
                                    dateDebut: null,
                                    dateFin: null,
                                    immatriculation: null,
                                    marque: null,
                                    modele: null,
                                    usageLibelle: null,
                                    codeUsage: null,
                                    energie: null,
                                    anneeVignette: null,
                                    user: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('prospection', null, { reload: true });
                    }, function() {
                        $state.go('prospection');
                    })
                }]
            })
            .state('prospection.edit', {
                parent: 'prospection.detail',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/prospection/prospection-dialog.html',
                        controller: 'ProspectionDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Prospection', function(Prospection) {
                                return Prospection.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('prospection.detail', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            

            .state('prospection.delete', {
                parent: 'prospection',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/prospection/prospection-delete-dialog.html',
                        controller: 'ProspectionDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Prospection', function(Prospection) {
                                return Prospection.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('prospection', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
                        .state('prospection.take', {
                parent: 'prospection',
                url: '/{id}/take',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/prospection/prospection-take-dialog.html',
                        controller: 'ProspectionTakeController',
                        size: 'md',
                        resolve: {
                            entity: ['Prospection', function(Prospection) {
                                                            	
                            	return Prospection.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('prospection', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('prospection.unlock', {
            	parent: 'prospection.detail',
            	url: '/{id}/unlock',
            	data: {
            		authorities: ['ROLE_USER'],
            	},
            	onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            		$uibModal.open({
            			templateUrl: 'scripts/app/entities/prospection/prospection-unlock-dialog.html',
            			controller: 'ProspectionTakeController',
            			size: 'md',
            			resolve: {
            				entity: ['Prospection', function(Prospection) {
            					
            					return Prospection.get({id : $stateParams.id});
            				}]
            			}
            		}).result.then(function(result) {
            			$state.go('prospection', null, { reload: true });
            		}, function() {
            			$state.go('^');
            		})
            	}]
            })
   // State 360         
             .state('prospection.360', {
            	parent: 'entity',
            	url: '/prospection/360/{id}',
            	data: {
            		authorities: ['ROLE_USER'],
            		pageTitle: 'creamApp.prospection.detail.title'
            	},
            	views: {
            		'content@': {
            			templateUrl: 'scripts/app/entities/prospection/prospection-detail.html',
            			controller: 'ProspectionDetailController'
            		}
            	},
            	resolve: {
            		translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
            			$translatePartialLoader.addPart('prospection');
            			$translatePartialLoader.addPart('action');
            			$translatePartialLoader.addPart('compagne');
            			$translatePartialLoader.addPart('personne');
            			$translatePartialLoader.addPart('tache');
            			$translatePartialLoader.addPart('typeAction');
            			return $translate.refresh();
            		}],
            		entity: ['$stateParams', 'Prospection', function($stateParams, Prospection) {
            			return Prospection.get({id : $stateParams.id}).$promise;
            		}]
            	}
            })
            .state('prospection360.edit', {
                parent: 'prospection.360',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/prospection/prospection-dialog.html',
                        controller: 'ProspectionDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Prospection', function(Prospection) {
                                return Prospection.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('prospection.360', null, { reload: true });
                    }, function() {
                        $state.go('prospection.360');
                    })
                }]
            })
            
        .state('prospection.detail.personne_edit', {
            	parent: 'prospection.detail',
            	url: '/personnes/{personneId}/edit',
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
            					return Personne.get({id : $stateParams.personneId});
            				}]
            			}
            		}).result.then(function(result) {
            			$state.go('prospection.detail', null, { reload: true });
            		}, function() {
            			$state.go('prospection.detail');
            		})
            	}]
            })
            
            
            
                        .state('prospection.detail.action_new', {
                parent: 'prospection.detail',
                url: '/action/new/{type}',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/action/action-dialog-360.html',
                        controller: 'ActionDialogController',
                        size: 'md',
                        resolve: {
                            entity: function () {
                                return {
                                    sujet: $stateParams.type,
                                    description: null,
                                    dateDebut: new Date(),
                                    dateFin: null,
                                    typeAction: $stateParams.type,
                                    user: null,
                                    id: null,
                                    decision : null ,
                                    tacheId:$stateParams.tacheId ,
                                    _prospectionId : $stateParams.id ,
                                    _numeroContrat : null 
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('prospection.detail', null, { reload: true });
                    }, function() {
                        $state.go('prospection.detail');
                    })
                }]
            })
            .state('prospection.detail.tache_close', {
                parent: 'prospection.detail',
                url: '/{idTache}/close',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/tache/tache-close-dialog.html',
                        controller: 'TacheCloseController',
                        size: 'md',
                        resolve: {
                            entity: ['Tache', function(Tache) {
                                return Tache.get({id : $stateParams.idTache});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('prospection.detail', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('prospection.detail.concretiser', {
                parent: 'prospection.detail',
                url: '/concretiser',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/action/concretiser-dialog-360.html',
                        controller: 'ActionDialogController',
                        size: 'md',
                        resolve: {
                            entity: function () {
                                return {
                                    sujet: 'CONCRETISATION',
                                    description: null,
                                    dateDebut: new Date(),
                                    dateFin: null,
                                    typeAction: 'CONCRETISATION',
                                    user: null,
                                    id: null,
                                    _prospectionId : $stateParams.id ,
                                    _numeroContrat : null 
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('prospection.detail', null, { reload: true });
                    }, function() {
                        $state.go('prospection.detail');
                    })
                }]
            })
                        .state('prospection.detail.abondonner', {
                parent: 'prospection.detail',
                url: '/abondonner',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/action/abandonner-dialog-360.html',
                        controller: 'ActionDialogController',
                        size: 'md',
                        resolve: {
                            entity: function () {
                                return {
                                    sujet: 'ABANDON',
                                    description: null,
                                    dateDebut: new Date(),
                                    dateFin: null,
                                    typeAction: 'ABANDONNER',
                                    user: null,
                                    id: null,
                                    tacheId:$stateParams.tacheId ,
                                    _prospectionId : $stateParams.id ,
                                    _numeroContrat : null 
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('prospection.detail', null, { reload: true });
                    }, function() {
                        $state.go('prospection.detail');
                    })
                }]
            })
    });
