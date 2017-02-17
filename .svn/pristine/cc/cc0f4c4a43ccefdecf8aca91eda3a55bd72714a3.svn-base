'use strict';

angular.module('creamApp')
    .controller('RefStatutTacheController', function ($scope, $state, RefStatutTache, RefStatutTacheSearch) {

        $scope.refStatutTaches = [];
        $scope.loadAll = function() {
            RefStatutTache.query(function(result) {
               $scope.refStatutTaches = result;
            });
        };
        $scope.loadAll();


        $scope.search = function () {
            RefStatutTacheSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.refStatutTaches = result;
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
            $scope.refStatutTache = {
                code: null,
                libelle: null,
                id: null
            };
        };
    });
