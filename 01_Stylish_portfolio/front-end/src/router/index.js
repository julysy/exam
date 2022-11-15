import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
  },
  {
    path: "/menu",
    name: "menu",
    component: () => import("../views/MenuView.vue"),
    // 자식 router-view 호출 : children
    children: [
      // 부서 전체 조회 페이지
      {
        path: "dept",
        name: "dept",
        component: () => import("../components/dept/DeptList.vue"),
      },
      // 부서 추가 페이지
      {
        path: "add/dept",
        name: "add-dept",
        component: () => import("../components/dept/AddDept.vue"),
      },
      // 부서 상세 페이지
      {
        path: "dept/:dno",
        name: "dept-detail",
        component: () => import("../components/dept/DeptDetail.vue"),
      },
      // 전체 Customer 목록 페이지
      {
        path: "customer",
        name: "customer",
        component: () => import("../components/customer/CustomerList.vue"),
      },
      // Customer 추가 페이지
      {
        path: "add/customer",
        name: "add-customer",
        component: () => import("../components/customer/AddCustomer.vue"),
      },
      // Customer 상세 페이지
      {
        path: "customer/:cid",
        name: "customer-detail",
        component: () => import("../components/customer/CustomerDetail.vue"),
      },
      // 전체 Qna 목록 페이지
      {
        path: "qna",
        name: "qna",
        component: () => import("../components/qna/QnaList.vue"),
      },
      // Qna 추가 페이지
      {
        path: "add/qna",
        name: "add-qna",
        component: () => import("../components/qna/AddQna.vue"),
      },
      // Qna 상세 페이지
      {
        path: "qna/:qno",
        name: "qna-detail",
        component: () => import("../components/qna/QnaDetail.vue"),
      },
      // Gallery Upload 페이지
      {
        path: "galleryDb",
        name: "galleryDb",
        component: () => import("../components/galleryDb/GalleryDbUpload.vue"),
      },
      // Excel dept Upload 페이지
      {
        path: "excel/dept",
        name: "excel-dept",
        component: () => import("../components/excel/DeptExcelUpload.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;