'use strict';

angular.module('creamApp')
    .factory('PerferenceSearch', function ($resource) {
        return $resource('api/_search/perferences/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
