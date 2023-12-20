var app = angular.module('my-app');

app.controller('product-controller', function ($scope, $http, $window, $sce) {
  $scope.products = [];
  $scope.brands = [];
  $scope.categoris = [];
  $scope.selectedProducts = [];

  $scope.products = {};

  $scope.selectedCategory = null;


  $http.get('/rest/product')
    .then(function (response) {
      $scope.products = response.data;
      $scope.allProducts = response.data;

    });

  $http.get('/rest/brand')
    .then(function (response) {
      $scope.brands = response.data;
    });

  $http.get('/rest/category')
    .then(function (response) {
      $scope.categoris = response.data;
    });

  $scope.loadProductsByBrand = function (brandID) {
    $http.get('/rest/products-by-brand?brandID=' + brandID)
      .then(function (response) {
        console.log(brandID)
        if (response.data.length === 0) {
          $scope.noProductsFound = true; // Hiển thị thông báo nếu không có sản phẩm nào được tìm thấy
        } else {
          $scope.noProductsFound = false; // Ẩn thông báo nếu có sản phẩm được tìm thấy
        }
        $scope.products = response.data;
      })
      .catch(function (error) {
        console.error('Error fetching products:', error);
      });
  };

  $scope.filterDataBrand = function (brandID) {
    // Tải loại dựa trên brandID
    $http.get('/categories-by-brand/' + brandID)
      .then(function (response) {
        if (response.data.length === 0) {
          $scope.noProductsFound = true; // Hiển thị thông báo nếu không có sản phẩm nào được tìm thấy
        } else {
          $scope.noProductsFound = false; // Ẩn thông báo nếu có sản phẩm được tìm thấy
        }
        $scope.categoris = filterUniqueCategories(response.data);
      })
      .catch(function (error) {
        console.error('Error fetching categories:', error);
      });

    // Tải sản phẩm dựa trên brandID
    $http.get('/products-by-brand/' + brandID)
      .then(function (response) {
        if (response.data.length === 0) {
          $scope.noProductsFound = true; // Hiển thị thông báo nếu không có sản phẩm nào được tìm thấy
        } else {
          $scope.noProductsFound = false; // Ẩn thông báo nếu có sản phẩm được tìm thấy
        }
        $scope.products = response.data;
      })
      .catch(function (error) {
        console.error('Error fetching products:', error);
      });
  };

  // Hàm lọc danh sách brand để chỉ hiển thị một brand duy nhất nếu có
  function filterUniqueBrands(brands) {
    const uniqueBrands = [];
    const brandMap = {};

    brands.forEach(brand => {
      if (!brandMap[brand.brandName]) {
        uniqueBrands.push(brand);
        brandMap[brand.brandName] = true;
      }
    });

    return uniqueBrands;
  }

  $scope.loadProductsByCategory = function (categoryID) {
    $http.get('/rest/products-by-category/' + categoryID)
      .then(function (response) {
        $scope.products = filterUniqueCategories(response.data);
      })
      .catch(function (error) {
        console.error('Error fetching products:', error);
      });
  };

  $scope.loadProductsByCategoryNav = function (categoryID) {
    $http.get('/rest/products-by-category/' + categoryID)
      .then(function (response) {
        $scope.products = response.data;
      })
      .catch(function (error) {
        console.error('Error fetching products:', error);
      });
  }

  // Hàm lọc danh sách loại sản phẩm để chỉ hiển thị một category duy nhất nếu có
  function filterUniqueCategories(categories) {
    const uniqueCategories = [];
    const categoryMap = {};

    categories.forEach(category => {
      if (!categoryMap[category.categoryID]) {
        uniqueCategories.push(category);
        categoryMap[category.categoryID] = true;
      }
    });

    return uniqueCategories;
  }

  $scope.toggleSelection = function (selectedItem) {
    if (selectedItem.selected) {
      // Nếu một checkbox được chọn, hủy chọn các checkbox khác
      $scope.categoris.forEach(function (item) {
        if (item !== selectedItem) {
          item.selected = false;
        }
      });
      $scope.selectedCategory = selectedItem.categoryID;
      $scope.filterData(selectedItem.categoryID);
    } else if (selectedItem.categoryID === $scope.selectedCategory) {
      // Nếu checkbox được bỏ chọn và là checkbox hiện đang được chọn, tải lại trang
      location.reload();
    }
  };

});

