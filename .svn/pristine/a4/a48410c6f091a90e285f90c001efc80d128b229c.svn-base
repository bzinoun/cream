'use strict';

angular.module('creamApp')
    .controller('RefSituationFamilialeController', function ($scope, $state, RefSituationFamiliale, RefSituationFamilialeSearch) {

        $scope.refSituationFamiliales = [];
        $scope.loadAll = function() {
            RefSituationFamiliale.query(function(result) {
               $scope.refSituationFamiliales = result;
            });
        };
        $scope.loadAll();


        $scope.search = function () {
            RefSituationFamilialeSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.refSituationFamiliales = result;
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
            $scope.refSituationFamiliale = {
                code: null,
                libelle: null,
                id: null
            };
        };
    });
