'use strict';

angular.module('creamApp')
    .controller('RefStatutCompagneController', function ($scope, $state, RefStatutCompagne, RefStatutCompagneSearch) {

        $scope.refStatutCompagnes = [];
        $scope.loadAll = function() {
            RefStatutCompagne.query(function(result) {
               $scope.refStatutCompagnes = result;
            });
        };
        $scope.loadAll();


        $scope.search = function () {
            RefStatutCompagneSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.refStatutCompagnes = result;
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
            $scope.refStatutCompagne = {
                code: null,
                libelle: null,
                id: null
            };
        };
    });
