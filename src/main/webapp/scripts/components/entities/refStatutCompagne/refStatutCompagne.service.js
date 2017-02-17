'use strict';

angular.module('creamApp')
    .factory('RefStatutCompagne', function ($resource, DateUtils) {
        return $resource('api/refStatutCompagnes/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    });
