/*
Navicat MySQL Data Transfer

Source Server         : kekeblog
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : tz_zone

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2016-02-13 02:13:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tz_comment
-- ----------------------------
DROP TABLE IF EXISTS `tz_comment`;
CREATE TABLE `tz_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(120) DEFAULT NULL,
  `content` longtext,
  `user_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0未发布1发布',
  `is_delete` int(1) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `tag` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=362 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tz_comment
-- ----------------------------
INSERT INTO `tz_comment` VALUES ('1', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('2', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('3', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('4', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('302', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('303', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('304', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('305', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('306', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('307', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('308', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('309', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('310', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('311', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('312', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('313', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('314', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('315', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('316', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('317', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('318', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('319', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('320', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('321', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('322', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('323', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('324', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('325', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('326', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('327', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('328', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('329', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('330', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('331', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('332', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('333', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('334', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('335', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('336', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('337', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('338', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('339', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('340', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('341', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('342', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('343', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('344', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('345', '我将自己埋进尘埃', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('346', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('347', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('348', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('349', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('350', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('351', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('352', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('353', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('354', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('355', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('356', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('357', 'Event Handling', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('358', '我将自己埋进尘埃', '我将自己埋进尘埃\n然后 在比地面还低的地方开出花来\n仅仅是一首歌的时间\n而我内心的激荡如丝绸般铺展开来\n\n本期音乐为爱尔兰独立音乐专题，有着明显的英式摇滚特征。这些音乐带着心底泛起的温情，夹杂着终究只有电影里才有的美丽情节，浮光掠影般的从人们的心头掠过。就像一场盛大的仪式，浩浩荡荡的一去不复返。', '1', '2016-02-12 20:00:05', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('359', 'jQuery is a fast, s', 'jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. With a combination of versatility and extensibility, jQuery has changed the way that millions of people write JavaScript.\n\nCorporate M', '1', '2016-02-12 23:56:52', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('360', 'What is jQuery?', ' Download jQuery\nv1.12.0 or v2.2.0\nView Source on GitHub →\nHow jQuery Works →\nLightweight Footprint\n\nOnly 32kB minified and gzipped. Can also be included as an AMD module\n\nCSS3 Compliant\n\nSupports CSS3 selectors to find elements as well as in style property manipulation\n\nCross-Browser\n\nIE, Firefox, Safari, Opera, Chrome, and more\n\nWhat is jQuery?\njQuery is a fast, small, and feature-rich JavaScrip', '1', '2016-02-12 23:57:00', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');
INSERT INTO `tz_comment` VALUES ('361', '我将自己埋进尘埃', 'Event Handling\n\nShow the #banner-message element that is hidden with  display:none in its CSS when any button in #button-container is clicked.\n\n1\n2\n3\n4\nvar hiddenBox = $( \"#banner-message\" );\n$( \"#button-container button\" ).on( \"click\", function( event ) {\n  hiddenBox.show();\n});\nAjax\n\nCall a local script on the server /api/getWeather with the query parameter zipcode=97201 and replace the element ', '2', '2016-02-12 23:57:09', '2016-02-13 01:31:04', '1', '0', '0', 'java,javascript');

-- ----------------------------
-- Table structure for tz_message
-- ----------------------------
DROP TABLE IF EXISTS `tz_message`;
CREATE TABLE `tz_message` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `message` varchar(600) DEFAULT NULL,
  `accept_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `is_delete` int(1) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0未阅读1阅读',
  `leval` int(11) DEFAULT NULL COMMENT '0不紧急1紧急的',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tz_message
-- ----------------------------

-- ----------------------------
-- Table structure for tz_tag
-- ----------------------------
DROP TABLE IF EXISTS `tz_tag`;
CREATE TABLE `tz_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagname` varchar(10) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tz_tag
-- ----------------------------

-- ----------------------------
-- Table structure for tz_tag_comment
-- ----------------------------
DROP TABLE IF EXISTS `tz_tag_comment`;
CREATE TABLE `tz_tag_comment` (
  `comment_id` int(11) DEFAULT NULL,
  `tag_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tz_tag_comment
-- ----------------------------
INSERT INTO `tz_tag_comment` VALUES ('1', '1');
INSERT INTO `tz_tag_comment` VALUES ('1', '2');
INSERT INTO `tz_tag_comment` VALUES ('2', '1');

-- ----------------------------
-- Table structure for tz_user
-- ----------------------------
DROP TABLE IF EXISTS `tz_user`;
CREATE TABLE `tz_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(80) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `header_pic` varchar(100) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `is_delete` int(1) DEFAULT NULL COMMENT '0未删除1删除',
  `male` int(1) DEFAULT NULL COMMENT '0女1男',
  `sign` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tz_user
-- ----------------------------
INSERT INTO `tz_user` VALUES ('1', '柯柯', '123456', '15074816437', 'xuchengfeifei@qq.com', 'images/user_img1.jpg', '2016-02-12 23:59:06', '2016-02-12 23:59:32', '0', '1', '我行我素');
INSERT INTO `tz_user` VALUES ('2', '小叶', '123456', '15074816437', 'xuchengfeifei@qq.com', 'images/user_img2.jpg', '2016-02-12 23:59:06', '2016-02-12 23:59:32', '0', '1', '我行我素');
INSERT INTO `tz_user` VALUES ('3', '小章', '123456', '15074816437', 'xuchengfeifei@qq.com', 'images/user_img2.jpg', '2016-02-12 23:59:06', '2016-02-12 23:59:32', '0', '1', '我行我素');
INSERT INTO `tz_user` VALUES ('4', '小白', '123456', '15074816437', 'xuchengfeifei@qq.com', 'images/user_img2.jpg', '2016-02-12 23:59:06', '2016-02-12 23:59:32', '0', '1', '我行我素');
INSERT INTO `tz_user` VALUES ('5', '小C', '123456', '15074816437', 'xuchengfeifei@qq.com', 'images/user_img2.jpg', '2016-02-12 23:59:06', '2016-02-12 23:59:32', '0', '1', '我行我素');
INSERT INTO `tz_user` VALUES ('6', '小可', '123456', '15074816437', 'xuchengfeifei@qq.com', 'images/user_img2.jpg', '2016-02-12 23:59:06', '2016-02-12 23:59:32', '0', '1', '我行我素');

-- ----------------------------
-- Table structure for tz_user_fans
-- ----------------------------
DROP TABLE IF EXISTS `tz_user_fans`;
CREATE TABLE `tz_user_fans` (
  `user_id` int(11) NOT NULL,
  `fan_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tz_user_fans
-- ----------------------------

-- ----------------------------
-- Table structure for tz_user_hei
-- ----------------------------
DROP TABLE IF EXISTS `tz_user_hei`;
CREATE TABLE `tz_user_hei` (
  `user_id` int(11) NOT NULL,
  `for_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tz_user_hei
-- ----------------------------
