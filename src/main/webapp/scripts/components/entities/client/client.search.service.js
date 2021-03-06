'use strict';

angular.module('creamApp')
    .factory('ClientSearch', function ($resource) {
        return $resource('api/_search/clients/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
