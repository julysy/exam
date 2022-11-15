<template>
  <div>
    <!-- Navigation-->
    <a class="menu-toggle rounded" href="#"><i class="fas fa-bars"></i></a>
    <nav id="sidebar-wrapper">
      <ul class="sidebar-nav">
        <li class="sidebar-brand"><a href="#page-top">Start Bootstrap</a></li>
        <li class="sidebar-nav-item"><a href="#page-top">Home</a></li>
        <li class="sidebar-nav-item"><a href="#about">About</a></li>
        <li class="sidebar-nav-item"><a href="#services">Services</a></li>
        <li class="sidebar-nav-item"><a href="#portfolio">Portfolio</a></li>
        <li class="sidebar-nav-item"><a href="#contact">Contact</a></li>
      </ul>
    </nav>
    <!-- Header-->
    <header class="masthead d-flex align-items-center">
      <div class="container px-4 px-lg-5 text-center">
        <h1 class="mb-1">Stylish Portfolio</h1>
        <h3 class="mb-5"><em>저의 블로그 사이트에 오신 것을 환영합니다.</em></h3>
        <a class="btn btn-primary btn-xl" href="#about">자세히 알아보기</a>
      </div>
    </header>
    <!-- About-->
    <section class="content-section bg-light" id="about">
      <div class="container px-4 px-lg-5 text-center">
        <div class="row gx-4 gx-lg-5 justify-content-center">
          <div class="col-lg-10">
            <h2>
              부산여행의 모든 것
            </h2>
            <p class="lead mb-5">
              부산 주요 관광지에 대한 정보를 제공해 드립니다. 
            </p>
            <a class="btn btn-dark btn-xl" href="#services">Services</a>
          </div>
        </div>
      </div>
    </section>
    <!-- Services-->
    <section
      class="content-section bg-primary text-white text-center"
      id="services"
    >
      <div class="container px-4 px-lg-5">
        <div class="content-section-heading">
          <h3 class="text-secondary mb-0">Services</h3>
          <h2 class="mb-5">무엇을 제공해 드리나요?</h2>
        </div>
        <div class="row gx-4 gx-lg-5">
          <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
            <span class="service-icon rounded-circle mx-auto mb-3"
              ><i class="icon-screen-smartphone"></i
            ></span>
            <h4><strong>부산 관광 자료</strong></h4>
            <p class="text-faded mb-0">부산 주요 관광지 소개</p>
          </div>
          <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
            <span class="service-icon rounded-circle mx-auto mb-3"
              ><i class="icon-pencil"></i
            ></span>
            <h4><strong>Gallery</strong></h4>
            <p class="text-faded mb-0">부산 주요 관광지 사진모음</p>
          </div>
          <div class="col-lg-3 col-md-6 mb-5 mb-md-0">
            <span class="service-icon rounded-circle mx-auto mb-3"
              ><i class="icon-like"></i
            ></span>
            <h4><strong>추천하는 관광지</strong></h4>
            <p class="text-faded mb-0">
              요즘 핫한 관광지 소개
              <i class="fas fa-heart"></i>
            </p>
          </div>
          <div class="col-lg-3 col-md-6">
            <span class="service-icon rounded-circle mx-auto mb-3"
              ><i class="icon-mustache"></i
            ></span>
            <h4><strong>질문있어요!</strong></h4>
            <p class="text-faded mb-0">무엇이든 물어보세요</p>
          </div>
        </div>
      </div>
    </section>
    <!-- Callout-->
    <section class="callout">
      <div class="container px-4 px-lg-5 text-center">
        <h2 class="mx-auto mb-5">
          Welcome to
          <em>Busan</em>
          !
        </h2>
        <a
          class="btn btn-primary btn-xl"
          href="#portfolio"
          >주요 관광지 소개</a
        >
      </div>
    </section>
    <!-- Portfolio-->
    <section class="content-section" id="portfolio">
      <div class="container px-4 px-lg-5">
        <div class="content-section-heading text-center">
          <h3 class="text-secondary mb-0">Welcome to Busan</h3>
          <h2 class="mb-5">최근 핫한 관광지 소개</h2>
        </div>
        <div class="row gx-0">
          <div class="col-lg-6">
            <a class="portfolio-item" href="/menu/dept">
              <div class="caption">
                <div class="caption-content">
                  <div class="h2">서면</div>
                  <p class="mb-0">
                    흔히 '서면'이라 불리는 부전동 및 일부 전포동 지역은 부산광역시의 주요 도심이자 부산시내 교통망의 중심축 지역이다. 
                  </p>
                </div>
              </div>
              <img
                class="img-fluid"
                src="../assets/img/서면.jpg"
                alt="..."
              />
            </a>
          </div>
          <div class="col-lg-6">
            <a class="portfolio-item" href="/menu/customer">
              <div class="caption">
                <div class="caption-content">
                  <div class="h2">송도</div>
                  <p class="mb-0">
                    방문객 순위로 해운대해수욕장과 광안리해수욕장을 잇는 부산 제3, 전국 제4의 해수욕장이다.
                  </p>
                </div>
              </div>
              <img
                class="img-fluid"
                src="../assets/img/송도.jpg"
                alt="..."
              />
            </a>
          </div>
          <div class="col-lg-6">
            <a class="portfolio-item" href="/menu/galleryDB">
              <div class="caption">
                <div class="caption-content">
                  <div class="h2">광안리</div>
                  <p class="mb-0">
                    부산광역시 수영구 광안동 소재이며, 해수욕장 좌우의 끝쪽은 남천동과 민락동에 속해있다. 해변 맞은편에는 부산의 랜드마크 광안대교가 자리잡고 있다.
                  </p>
                </div>
              </div>
              <img
                class="img-fluid"
                src="../assets/img/광안리.jpg"
                alt="..."
              />
            </a>
          </div>
          <div class="col-lg-6">
            <a class="portfolio-item" href="/menu/excel/dept">
              <div class="caption">
                <div class="caption-content">
                  <div class="h2">해운대</div>
                  <p class="mb-0">
                    부산광역시 해운대구에 있는 해수욕장. 광안대교와 더불어 외지인들에게 가장 유명한 부산의 양대 랜드마크이다.
                  </p>
                </div>
              </div>
              <img
                class="img-fluid"
                src="../assets/img/해운대.jpg"
                alt="..."
              />
            </a>
          </div>
        </div>
      </div>
    </section>
    <!-- Call to Action-->
    <section class="content-section bg-primary text-white">
      <div class="container px-4 px-lg-5 text-center">
        <h2 class="mb-4">The buttons below are impossible to resist...</h2>
        <a class="btn btn-xl btn-light me-4" href="/menu/qna">Question</a>
        <a class="btn btn-xl btn-dark" href="/menu/galleryDB">Look at Gallery!</a>
      </div>
    </section>
    <!-- Map-->
    <div class="map" id="contact">
      <iframe
        src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A&amp;output=embed"
      ></iframe>
      <br />
      <small
        ><a
          href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A"
        ></a
      ></small>
    </div>
    <!-- Footer-->
    <footer class="footer text-center">
      <div class="container px-4 px-lg-5">
        <ul class="list-inline mb-5">
          <li class="list-inline-item">
            <a class="social-link rounded-circle text-white mr-3" href="#!"
              ><i class="icon-social-facebook"></i
            ></a>
          </li>
          <li class="list-inline-item">
            <a class="social-link rounded-circle text-white mr-3" href="#!"
              ><i class="icon-social-twitter"></i
            ></a>
          </li>
          <li class="list-inline-item">
            <a class="social-link rounded-circle text-white" href="#!"
              ><i class="icon-social-github"></i
            ></a>
          </li>
        </ul>
        <p class="text-muted small mb-0">Copyright &copy; Your Website 2022</p>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top"
      ><i class="fas fa-angle-up"></i
    ></a>
  </div>
</template>

<script>
import stylishPortfolio from "../assets/js/scripts";

export default {
  mounted() {
    stylishPortfolio()
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/styles.css";
</style>
