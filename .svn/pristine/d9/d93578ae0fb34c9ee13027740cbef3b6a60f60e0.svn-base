'use strict';

angular.module('creamApp')
    .factory('Perference', function ($resource, DateUtils) {
        return $resource('api/perferences/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.dateImport = DateUtils.convertDateTimeFromServer(data.dateImport);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    });

angular.module('creamApp')
.factory('ImportProspect', function ($resource, DateUtils) {
    return $resource('api/perferences/import/:id', {}, {
        'query': { method: 'GET', isArray: true},
        'get': {
            method: 'GET',
            transformResponse: function (data) {
                data = angular.fromJson(data);
                data.dateImport = DateUtils.convertDateTimeFromServer(data.dateImport);
                return data;
            }
        },
        'update': { method:'PUT' }
    });
});