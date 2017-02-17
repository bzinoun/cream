'use strict';

angular.module('creamApp')
    .factory('RefSituationFamiliale', function ($resource, DateUtils) {
        return $resource('api/refSituationFamiliales/:id', {}, {
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
