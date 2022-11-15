<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" class="navbar-brand ms-3">SimpleDMS</router-link>
      <div class="navbar-nav mr-auto">
        <!-- 대메뉴 #1 : 부서정보 -->
        <li class="nav-item dropdown ms-3">
          <a
            class="nav-link dropdown-toggle"
            data-bs-toggle="dropdown"
            href="#"
            role="button"
            aria-expanded="false"
            >Department Info</a
          >
          <ul class="dropdown-menu">
            <li>
              <router-link to="/menu/dept" class="dropdown-item">Dept</router-link>
            </li>
            <li>
              <router-link to="/menu/add/dept" class="dropdown-item"
                >Add</router-link
              >
            </li>
          </ul>
        </li>

        <!-- 대메뉴 #2 : Customer -->
        <li class="nav-item dropdown ms-3">
          <a
            class="nav-link dropdown-toggle"
            data-bs-toggle="dropdown"
            href="#"
            role="button"
            aria-expanded="false"
            >Customer Info</a
          >
          <ul class="dropdown-menu">
            <li>
              <router-link to="/menu/customer" class="dropdown-item"
                >Customer</router-link
              >
            </li>
            <li>
              <router-link to="/menu/add/customer" class="dropdown-item"
                >Add</router-link
              >
            </li>
          </ul>
        </li>

        <!-- 대메뉴 #3 : Qna -->
        <li class="nav-item dropdown ms-3">
          <a
            class="nav-link dropdown-toggle"
            data-bs-toggle="dropdown"
            href="#"
            role="button"
            aria-expanded="false"
            >Qna Info</a
          >
          <ul class="dropdown-menu">
            <li>
              <router-link to="/menu/qna" class="dropdown-item">Qna</router-link>
            </li>
            <li>
              <router-link to="/menu/add/qna" class="dropdown-item">Add</router-link>
            </li>
          </ul>
        </li>

        <!-- 대메뉴 #4 : Gallery Upload -->
        <li class="nav-item ms-3">
          <a class="nav-link" aria-current="page" href="/menu/galleryDb"
            >Gallery Upload</a
          >
        </li>

        <!-- 대메뉴 #5 : Excel Upload -->
        <li class="nav-item dropdown ms-3">
          <a
            class="nav-link dropdown-toggle"
            data-bs-toggle="dropdown"
            href="#"
            role="button"
            aria-expanded="false"
            >Excel</a
          >
          <ul class="dropdown-menu">
            <li>
              <router-link to="/menu/excel/dept" class="dropdown-item">Dept Upload</router-link>
            </li>
          </ul>
        </li>
      </div>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
};
</script>