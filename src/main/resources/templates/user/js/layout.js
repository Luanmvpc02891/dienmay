var app = angular.module("myapp", ["ngRoute"]);


app.run(function ($rootScope) {
    $rootScope.$on('$routeChangeStart', function () {
        $rootScope.loading = true;
    });
    $rootScope.$on('$routeChangeSuccess', function () {
        $rootScope.loading = false;
    });
    $rootScope.$on('$routeChangeError', function () {
        $rootScope.loading = false;
        alert("Lỗi");
    });
});
app.config(function ($routeProvider) {
    $routeProvider
        .when('/index', {
            templateUrl: 'index.html',
            controller: 'indexctrl'
        }) .when('/shop', {
            templateUrl: 'shop-gird.html',
            controller: 'shopctrl'
        }).when('/blog', {
            templateUrl: 'blog.html',
            controller: 'blogctrl'
        }).when('/contact', {
            templateUrl: 'contact.html',
            controller: 'blogctrl'
        })
        .when('/blog-details', {
            templateUrl: 'blog-details.html',
            controller: 'blogdetailctrl'
        })
        .when('/checkout', {
            templateUrl: 'checkout.html',
            controller: 'checkoutctrl'
        })
        .when('/shoping-cart', {
            templateUrl: 'shoping-cart.html',
            controller: 'shopingcartctrl'
        })
        .when('/shop-details', {
            templateUrl: 'shop-details.html',
            controller: 'shoping-details'
        })
        .otherwise({
            redirectTo: '/index'
        });

});
app.controller('CarouselController', function($scope, $timeout) {
    $timeout(function() {
        $(".latest-product__slider").owlCarousel({
          loop: true,
          margin: 0,
          items: 1,
          dots: false,
          nav: true,
          navText: ["<span class='fa fa-angle-left'></span>", "<span class='fa fa-angle-right'></span>"],
          smartSpeed: 1200,
          autoHeight: false,
          autoplay: true
        });
      });
  });
  