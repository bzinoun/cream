'use strict';

angular.module('creamApp')
    .controller('RefSecteurActiviteController', function ($scope, $state, RefSecteurActivite, RefSecteurActiviteSearch) {

        $scope.refSecteurActivites = [];
        $scope.loadAll = function() {
            RefSecteurActivite.query(function(result) {
               $scope.refSecteurActivites = result;
            });
        };
        $scope.loadAll();


        $scope.search = function () {
            RefSecteurActiviteSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.refSecteurActivites = result;
            }, function(response) {
                if(response.status === 404) {
                    $scope.loadAll();
                }
            });
        };

        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.refSecteurActivite = {
                code: null,
                libelle: null,
                id: null
            };
        };
    });
