'use strict';

angular.module('creamApp')
    .controller('ActionController', function ($scope, $state, Action, ActionSearch, ParseLinks) {

        $scope.actions = [];
        $scope.predicate = 'id';
        $scope.reverse = true;
        $scope.page = 1;
        $scope.loadAll = function() {
            Action.query({page: $scope.page - 1, size: 20, sort: [$scope.predicate + ',' + ($scope.reverse ? 'asc' : 'desc'), 'id']}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.totalItems = headers('X-Total-Count');
                $scope.actions = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();


        $scope.search = function () {
            ActionSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.actions = result;
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
            $scope.action = {
                sujet: null,
                description: null,
                dateDebut: null,
                dateFin: null,
                typeAction: null,
                user: null,
                id: null
            };
        };
    });
