package com.demo.aggregator.services;


import com.demo.aggregator.model.Vacancy;
import com.demo.aggregator.service.impl.RabotaUAVacancyParserService;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RabotUaVacancyParserServiceTest {

    private final String fullJson = "{\"took\":10,\"start\":0,\"count\":20,\"total\":793,\"hasGeoCount\":465,\"errorMessage\":null,\"documents\":[{\"id\":7966152,\"name\":\"Middle Java Developer\",\"logo\":\"1037_20180719141616.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-24a01700-9fcd-476d-91a6-3d5de64f9b18.jpg\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-24a01700-9fcd-476d-91a6-3d5de64f9b18.jpg\",\"publicationType\":2,\"date\":\"2020-10-16T00:01:00.923\",\"dateTxt\":\"1 день назад\",\"hot\":true,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":1037,\"companyName\":\"Райффайзен Банк Аваль\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":0.0,\"longitude\":0.0,\"shortDescription\":\"What do you need:2+ years of commercial experience with Java 8 +1+ years of writing unit-test2+ years of using jdbc, xml, mq, web-service's2+ years using of JavaServer Faces 2.0Ability to use Prime Faces, Angular, Spring BootExperience of using java-annotationFull\",\"badges\":[]},{\"id\":7940577,\"name\":\"Senior Java Developer\",\"logo\":\"1037_20180719141616.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-24a01700-9fcd-476d-91a6-3d5de64f9b18.jpg\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-24a01700-9fcd-476d-91a6-3d5de64f9b18.jpg\",\"publicationType\":2,\"date\":\"2020-10-15T12:03:29.687\",\"dateTxt\":\"2 дня назад\",\"hot\":true,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"Контрактовая площадь\",\"metroId\":28,\"districtName\":\"Подольский\",\"districtId\":7,\"notebookId\":1037,\"companyName\":\"Райффайзен Банк Аваль\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":50.4718563,\"longitude\":30.5192337,\"shortDescription\":\"Required skills:5+ years of experience in JavaDeep understanding of microservices architectural principlesDeep practical experience with Spring Boot (MVC, REST, Data, Security, messaging)Practical experience with Kubernetes and Helm for different environmentsHands-on\",\"badges\":[]},{\"id\":8176787,\"name\":\"Java Tech Lead\",\"logo\":\"1037_20180719141616.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-24a01700-9fcd-476d-91a6-3d5de64f9b18.jpg\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-24a01700-9fcd-476d-91a6-3d5de64f9b18.jpg\",\"publicationType\":2,\"date\":\"2020-10-15T12:03:21.28\",\"dateTxt\":\"2 дня назад\",\"hot\":true,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"Контрактовая площадь\",\"metroId\":28,\"districtName\":\"Подольский\",\"districtId\":7,\"notebookId\":1037,\"companyName\":\"Райффайзен Банк Аваль\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":50.4718563,\"longitude\":30.5192337,\"shortDescription\":\"Required skills:5+ years of experience in JavaDeep understanding of microservices architectural principlesDeep practical experience with Spring Boot (MVC, REST, Data, Security, messaging)Practical experience with Kubernetes and Helm for different environmentsHands-on\",\"badges\":[]},{\"id\":7963462,\"name\":\"Senior Java Engineer\",\"logo\":\"Sodeminders_20100507032200.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-80dfee20-4209-4211-ab51-15f32e7e3bb7.png\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-80dfee20-4209-4211-ab51-15f32e7e3bb7.png\",\"publicationType\":2,\"date\":\"2020-10-14T17:01:00.08\",\"dateTxt\":\"3 дня назад\",\"hot\":true,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"Васильковская\",\"metroId\":33,\"districtName\":\"Голосеевский\",\"districtId\":1,\"notebookId\":394872,\"companyName\":\"Codeminders\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":50.3949839,\"longitude\":30.4896115,\"shortDescription\":\"We are looking for Senior Java EngineerRequirements:BS or MS in Computer Science or related fieldSignificant experience in Java8 (Core, Networking, RES, RabbitMQ, CouchDB, Spring Framework, Google Protobuf, Google,Guava, javax.servlet, javax.ws.rs, Mockito,\",\"badges\":[]},{\"id\":8014226,\"name\":\"ESB Developer\",\"logo\":\"KREDI-AGRIKOLJ-BANK_20141113031607.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-02a26d30-6f80-434f-aaad-bb745c14a851.png\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-02a26d30-6f80-434f-aaad-bb745c14a851.png\",\"publicationType\":2,\"date\":\"2020-10-17T12:01:00.067\",\"dateTxt\":\"9 часов назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":307419,\"companyName\":\"КРЕДІ АГРІКОЛЬ БАНК\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":0.0,\"longitude\":0.0,\"shortDescription\":\"IBM Integration Bus Software Developer (ESB) Побажання до знань та досвіду:Розуміння Service oriented architecture (SOA);Практичні навички що до розробки Web Service (SOAP, REST);XML XSLT, WSDL, XSD, Xpath;Розуміння Java SE, основні положення OOП;СУБД\",\"badges\":[]},{\"id\":8141922,\"name\":\"Senior Android Developer\",\"logo\":\"845072_20170704104053.png\",\"designBannerUrl\":\"\",\"designBannerFullUrl\":\"\",\"publicationType\":1,\"date\":\"2020-10-17T08:01:00.7\",\"dateTxt\":\"13 часов назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":845072,\"companyName\":\"Printec Ukraine LLC\",\"formApplyCustomUrl\":\"https://apply.workable.com/j/D6402CF28B\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":0.0,\"longitude\":0.0,\"shortDescription\":\"Printec Group is the prime provider of technology solutions that focuses on transaction automation in 16 countries, mainly in Central &amp; Eastern Europe. Recruiting, developing and rewarding talent is central to our People Excellence philosophy. We\",\"badges\":[]},{\"id\":7887650,\"name\":\"Junior/Middle Java Developer,разработчик Java\",\"logo\":\"Gran-Soft_20100114013120.jpg\",\"designBannerUrl\":\"\",\"designBannerFullUrl\":\"\",\"publicationType\":1,\"date\":\"2020-10-17T04:01:00.117\",\"dateTxt\":\"17 часов назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Харьков\",\"cityId\":21,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":696098,\"companyName\":\"Gran-Soft\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":0.0,\"longitude\":0.0,\"shortDescription\":\"Мы занимаемся разработкой и развитием международного портала страховой медицины.Наш проект стал особенно важным и востребованным именно в это непростое время. Наша компания сразу дает возможность выполнять интересные задачи и получать достойную зарплату.Мы\",\"badges\":[{\"id\":420603,\"name\":\"интересный проект \"},{\"id\":420604,\"name\":\"профессиональный рост \"},{\"id\":420605,\"name\":\"достойная зарплата \"},{\"id\":420606,\"name\":\"гибкий график \"},{\"id\":420607,\"name\":\"медицинская тематика \"}]},{\"id\":8119694,\"name\":\"QA Automation Engineer (Selenium WebDriver + Java), Media Conglomerate\",\"logo\":\"277662_20170927154947.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-1f9b6e4c-da90-48c0-b1c5-9763bb8344a8.jpg\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-1f9b6e4c-da90-48c0-b1c5-9763bb8344a8.jpg\",\"publicationType\":2,\"date\":\"2020-10-17T00:26:30.09\",\"dateTxt\":\"20 часов назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":277662,\"companyName\":\"DataArt\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":0.0,\"longitude\":0.0,\"shortDescription\":\"DataArt is involved in software modernization of key business areas of one of the largest music conglomerates.The solutions we're currently developing affect various aspects of recording studios: tour organization, merchandising, management of licenses\",\"badges\":[]},{\"id\":8046547,\"name\":\"Middle+/Senior Java Developer\",\"logo\":\"583287_20181009174709.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-265f8b84-5dbd-4099-ac4d-f69a234d4202.png\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-265f8b84-5dbd-4099-ac4d-f69a234d4202.png\",\"publicationType\":2,\"date\":\"2020-10-17T00:26:10.16\",\"dateTxt\":\"20 часов назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":583287,\"companyName\":\"Альфа-Банк\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":0.0,\"longitude\":0.0,\"shortDescription\":\"Наша команда запускає унікальний проєкт на ринку України з фокусом на глобальну клієнтську діджиталізацію. Ми ніколи не стоїмо на місці, активно розвиваємося, та прагнемо першості! А мотивує нас #робота_на_мільйон, адже кожен день ми працюємо на мільйони:\",\"badges\":[]},{\"id\":5872044,\"name\":\"Android Developer\",\"logo\":\"PNN-Soft-TOV_20160226050210.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-5e7fdd49-f838-4a54-835e-62b417a0d82d.jpg\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-5e7fdd49-f838-4a54-835e-62b417a0d82d.jpg\",\"publicationType\":2,\"date\":\"2020-10-17T00:01:00.25\",\"dateTxt\":\"21 час назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":816229,\"companyName\":\"PNN Soft\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":0.0,\"longitude\":0.0,\"shortDescription\":\"Main responsibilities: Android mobile applications developmentInteraction with external services and devicesInternational projects work experience Requirements: Knowledge of Java, Android SDKHigher technical education (ready to hire a student)Knowledge\",\"badges\":[]},{\"id\":7207579,\"name\":\"Розробник інтеграційних рішень(ESB)\",\"logo\":\"4824814_20190925111042.png\",\"designBannerUrl\":\"\",\"designBannerFullUrl\":\"\",\"publicationType\":2,\"date\":\"2020-10-17T00:01:00.25\",\"dateTxt\":\"21 час назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"Лукьяновская\",\"metroId\":50,\"districtName\":\"Шевченковский\",\"districtId\":10,\"notebookId\":4824814,\"companyName\":\"ІТ СПЕЦІАЛІСТ, ТОВ\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":50.462417,\"longitude\":30.4818027,\"shortDescription\":\"Очікування від кандидата:вища технічна освіта;досвід роботи в сфері ІТ від 2-х років;знання основ XML, XSLT, XPath, SQL (PL / SQL, ESQL), Web Services (SOAP, REST)розуміння принципів SOA;базові знання Java, основ ООП;досвід роботи з реляційними базами\",\"badges\":[]},{\"id\":7312488,\"name\":\"Junior Java developer, QA Automation Test Engineer\",\"logo\":\"TestMatick_20150604020558.png\",\"designBannerUrl\":\"\",\"designBannerFullUrl\":\"\",\"publicationType\":1,\"date\":\"2020-10-17T00:01:00.25\",\"dateTxt\":\"21 час назад\",\"hot\":false,\"salary\":11000,\"cityName\":\"Кривой Рог\",\"cityId\":31,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":3274804,\"companyName\":\"TestMatick\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":47.910483,\"longitude\":33.391783,\"shortDescription\":\"Прежде чем откликнуться на вакансию, внимательно ознакомьтесь с нашими главными требованиями на эту должность:Твердые теоретические знание в области тестирования. Опыт приветствуется, но не обязателен.Разговорный английский не ниже Intermediate.Обязательно\",\"badges\":[]},{\"id\":8067269,\"name\":\"Senior tt developer \",\"logo\":\"defaultlogo.gif\",\"designBannerUrl\":\"\",\"designBannerFullUrl\":\"\",\"publicationType\":2,\"date\":\"2020-10-17T00:01:00.25\",\"dateTxt\":\"21 час назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"Левобережная\",\"metroId\":4,\"districtName\":\"Печерский\",\"districtId\":6,\"notebookId\":8603000,\"companyName\":\"Seekerapps\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":50.451864,\"longitude\":30.5981571,\"shortDescription\":\"Atlas IAC is a software product company from the betting industry. We develop the modern innovation product that meets European Standards. Our mission is creating a product industry haven't seen yet, a product on which we would like to work ourselves.\",\"badges\":[{\"id\":343099,\"name\":\"Безкоштовне навчання\"},{\"id\":343100,\"name\":\"Бонуси / премії\"},{\"id\":343101,\"name\":\"Компенсація навчання\"},{\"id\":343102,\"name\":\"Додаткові вихідні\"},{\"id\":343103,\"name\":\"Компенсація подорожей\"}]},{\"id\":7831041,\"name\":\"Group Manager\",\"logo\":\"Playtika-UA_20150119125108.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-246c65af-0743-4c3b-bc1d-64072d8e7e87.png\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-246c65af-0743-4c3b-bc1d-64072d8e7e87.png\",\"publicationType\":2,\"date\":\"2020-10-17T00:01:00.25\",\"dateTxt\":\"21 час назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"Осокорки\",\"metroId\":39,\"districtName\":\"\",\"districtId\":0,\"notebookId\":1409475,\"companyName\":\"Playtika UA\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":50.395248,\"longitude\":30.616231,\"shortDescription\":\"Playtika - the company of storytellers and coders, artists and data-scientists, explorers and strategists. Since 2010, Playtika has been a pioneer in the games industry. Playtika doesn't just build games. It brings them to life. Fueled by over six terabytes\",\"badges\":[{\"id\":181148,\"name\":\"Бесплатные обеды\"},{\"id\":181149,\"name\":\"Компенсация спортзала\"},{\"id\":181150,\"name\":\"Курсы иностранного языка\"},{\"id\":181151,\"name\":\"Медицинская страховка\"},{\"id\":181152,\"name\":\"Бонусы / премии\"}]},{\"id\":8015481,\"name\":\"Senior Java Developer\",\"logo\":\"6209095_20170914175157.png\",\"designBannerUrl\":\"\",\"designBannerFullUrl\":\"\",\"publicationType\":1,\"date\":\"2020-10-17T00:01:00.25\",\"dateTxt\":\"21 час назад\",\"hot\":false,\"salary\":135000,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"Крещатик\",\"metroId\":6,\"districtName\":\"Печерский\",\"districtId\":6,\"notebookId\":6209095,\"companyName\":\"Intel 471\",\"formApplyCustomUrl\":\"https://intel471.bamboohr.com/jobs/view.php?id=24\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":50.447162,\"longitude\":30.5230972,\"shortDescription\":\"Intel 471 is looking for a Senior Java Developer for our office in Kyiv. You will be developing high volume data engineering products, combining data from multiple sources into a single stream, having expertise in both web development and system development,\",\"badges\":[]},{\"id\":7906134,\"name\":\"Senior qq developer\",\"logo\":\"defaultlogo.gif\",\"designBannerUrl\":\"\",\"designBannerFullUrl\":\"\",\"publicationType\":2,\"date\":\"2020-10-17T00:01:00.25\",\"dateTxt\":\"21 час назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"Гидропарк\",\"metroId\":3,\"districtName\":\"Днепровский\",\"districtId\":4,\"notebookId\":8603000,\"companyName\":\"Seekerapps\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":50.449279,\"longitude\":30.475881,\"shortDescription\":\"Atlas IAC is a software product company from the betting industry. We develop the modern innovation product that meets European Standards. Our mission is creating a product industry haven't seen yet, a product on which we would like to work ourselves.\",\"badges\":[{\"id\":213793,\"name\":\"Бесплатное обучение\"},{\"id\":213794,\"name\":\"Бесплатные обеды\"},{\"id\":213795,\"name\":\"Бонусы / премии\"}]},{\"id\":8116307,\"name\":\"Big Data Engineer, Multinational Financial Services\",\"logo\":\"277662_20170927154947.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-1f9b6e4c-da90-48c0-b1c5-9763bb8344a8.jpg\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-1f9b6e4c-da90-48c0-b1c5-9763bb8344a8.jpg\",\"publicationType\":2,\"date\":\"2020-10-16T20:01:00.067\",\"dateTxt\":\"1 день назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Львов\",\"cityId\":2,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":277662,\"companyName\":\"DataArt\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":49.8344049,\"longitude\":23.995041,\"shortDescription\":\"DataArt's specialists participate in data governance and data improvement processes for one of the top three UK insurance companies. Our team helps the client in finding and clearing issues with the data. The Big Data engineer will be responsible for\",\"badges\":[]},{\"id\":8170424,\"name\":\"Senior Android Developer\",\"logo\":\"277662_20170927154947.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-1f9b6e4c-da90-48c0-b1c5-9763bb8344a8.jpg\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-1f9b6e4c-da90-48c0-b1c5-9763bb8344a8.jpg\",\"publicationType\":2,\"date\":\"2020-10-16T20:01:00.067\",\"dateTxt\":\"1 день назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Львов\",\"cityId\":2,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":277662,\"companyName\":\"DataArt\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":49.8344049,\"longitude\":23.995041,\"shortDescription\":\"The UK-based client has developed a digital health platform that allows users to obtain an online consultation from a therapist within 6 minutes. Among the main responsibilities are the improvement and development of new features for client apps, code\",\"badges\":[]},{\"id\":8170432,\"name\":\"Senior Java Developer, Subscription Management Solutions\",\"logo\":\"277662_20170927154947.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-1f9b6e4c-da90-48c0-b1c5-9763bb8344a8.jpg\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-1f9b6e4c-da90-48c0-b1c5-9763bb8344a8.jpg\",\"publicationType\":2,\"date\":\"2020-10-16T20:01:00.067\",\"dateTxt\":\"1 день назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Львов\",\"cityId\":2,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":277662,\"companyName\":\"DataArt\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":49.8344049,\"longitude\":23.995041,\"shortDescription\":\"Our client is a product company that builds market-leading software solutions for subscription spend &amp; usage management. They are expanding its New York-based development team by building up an independently located team of talented and highly motivated\",\"badges\":[]},{\"id\":8178964,\"name\":\"Android Java Developer (IRC95364)\",\"logo\":\"GlobalLogic-Ukraine_20141113034621.png\",\"designBannerUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-5468752b-ce80-4846-9289-3def1aad58a0.png\",\"designBannerFullUrl\":\"https://vacancyimages.rabota.ua/custom-vacancy-5468752b-ce80-4846-9289-3def1aad58a0.png\",\"publicationType\":2,\"date\":\"2020-10-16T19:06:20.96\",\"dateTxt\":\"1 день назад\",\"hot\":false,\"salary\":0,\"cityName\":\"Киев\",\"cityId\":1,\"metroName\":\"\",\"metroId\":0,\"districtName\":\"\",\"districtId\":0,\"notebookId\":794,\"companyName\":\"GlobalLogic Ukraine\",\"formApplyCustomUrl\":\"\",\"isLiked\":false,\"isApply\":false,\"applyDate\":null,\"lastViewDate\":null,\"distanceText\":\"\",\"latitude\":0.0,\"longitude\":0.0,\"shortDescription\":\"GlobalLogic Ukraine is inviting an Android Java Developer to join its Kyiv office.Our Client is the top Tier-1 company in the automotive world. Project goals are software implementation for Client infotainment hardware platform intended to be used in\",\"badges\":[]}]}";

    private final Integer exceptedVacanciesCount = 20;
    private final Vacancy testVacancy = new Vacancy("7966152", "Middle Java Developer", new Date(), "Киев", "Райффайзен Банк Аваль", "What do you need:2+ years of commercial experience with Java 8 +1+ years of writing unit-test2+ years of using jdbc, xml, mq, web-service's2+ years using of JavaServer Faces 2.0Ability to use Prime Faces, Angular, Spring BootExperience of using java-annotationFull", "");
    private final Vacancy emptyVacancy = new Vacancy();

    @Test
    void parse() {
        RabotaUAVacancyParserService service = new RabotaUAVacancyParserService();
        List<Vacancy> vacancies = service.parse(fullJson);
        assertThat(vacancies).isNotNull();
        assertThat(vacancies.size()).isEqualTo(exceptedVacanciesCount);

        Vacancy vacancy = vacancies.get(0);
        assertThat(vacancy).isNotEqualTo(emptyVacancy);
        assertThat(vacancy).isEqualTo(testVacancy);
    }
}
