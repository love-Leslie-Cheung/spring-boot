/*!
 * Distpicker v@VERSION
 * https://github.com/tshi0912/city-picker
 *
 * Copyright (c) 2014-@YEAR Tao Shi
 * Released under the MIT license
 *
 * Date: @DATE
 */

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as anonymous module.
        define('ChineseDistricts', [], factory);
    } else {
        // Browser globals.
        factory();
    }
})(function () {

    var ChineseDistricts = {
            100000: {
                ' ': [
                    {code: '200000', address: '华东'},
                    {code: '300000', address: '华南'},
                    {code: '400000', address: '华北'},
                    {code: '500000', address: '华中'},
                    {code: '600000', address: '西南'},
                    {code: '700000', address: '东北'},
                    {code: '800000', address: '西北'},
                    {code: '900000', address: '港澳台'}]
            },
            200000: {
                210000: '上海市',
                220000: '江苏省',
                230000: '浙江省',
                240000: '安徽省',
                250000: '江西省'
            },
            300000: {
                310000: '福建省',
                320000: '广东省',
                330000: '广西壮族自治区',
                340000: '海南省'
            },
            400000: {
                410000: '北京市',
                420000: '天津市',
                430000: '河北省',
                440000: '山西省',
                450000: '内蒙古自治区',
                460000: '山东省'
            },
            500000: {
                510000: '湖北省',
                520000: '湖南省',
                530000: '河南省'
            },
            600000: {
                610000: '四川省',
                620000: '贵州省',
                630000: '云南省',
                640000: '西藏自治区',
                650000: '重庆市'
            },
            700000: {
                710000: '辽宁省',
                720000: '吉林省',
                730000: '黑龙江省'
            },
            800000: {
                810000: '陕西省',
                820000: '甘肃省',
                830000: '青海省',
                840000: '宁夏回族自治区',
                850000: '新疆维吾尔自治区'
            },
            900000: {
                910000: '香港特别行政区',
                920000: '澳门特别行政区',
                930000: '台湾省'
            },
            410000: {
                410100: '北京市'
            },
            420000: {
                420100: '天津市'
            },
            430000: {
                430100: '石家庄市',
                430200: '唐山市',
                430300: '秦皇岛市',
                430400: '邯郸市',
                430500: '邢台市',
                430600: '保定市',
                430700: '张家口市',
                430800: '承德市',
                430900: '沧州市',
                431000: '廊坊市',
                431100: '衡水市'
            },
            440000: {
                440100: '太原市',
                440200: '大同市',
                440300: '阳泉市',
                440400: '长治市',
                440500: '晋城市',
                440600: '朔州市',
                440700: '晋中市',
                440800: '运城市',
                440900: '忻州市',
                441000: '临汾市',
                441100: '吕梁市'
            },
            450000: {
                450100: '呼和浩特市',
                450200: '包头市',
                450300: '乌海市',
                450400: '赤峰市',
                450500: '通辽市',
                450600: '鄂尔多斯市',
                450700: '呼伦贝尔市',
                450800: '巴彦淖尔市',
                450900: '乌兰察布市',
                452200: '兴安盟',
                452500: '锡林郭勒盟',
                452900: '阿拉善盟'
            },
            710000: {
                710100: '沈阳市',
                710200: '大连市',
                710300: '鞍山市',
                710400: '抚顺市',
                710500: '本溪市',
                710600: '丹东市',
                710700: '锦州市',
                710800: '营口市',
                710900: '阜新市',
                711000: '辽阳市',
                711100: '盘锦市',
                711200: '铁岭市',
                711300: '朝阳市',
                711400: '葫芦岛市'
            },
            720000: {
                720100: '长春市',
                720200: '吉林市',
                720300: '四平市',
                720400: '辽源市',
                720500: '通化市',
                720600: '白山市',
                720700: '松原市',
                720800: '白城市',
                722400: '延边朝鲜族自治州'
            },
            730000: {
                730100: '哈尔滨市',
                730200: '齐齐哈尔市',
                730300: '鸡西市',
                730400: '鹤岗市',
                730500: '双鸭山市',
                730600: '大庆市',
                730700: '伊春市',
                730800: '佳木斯市',
                730900: '七台河市',
                731000: '牡丹江市',
                731100: '黑河市',
                731200: '绥化市',
                732700: '大兴安岭地区'
            },
            210000: {
                210100: '上海市'
            },
            220000: {
                220100: '南京市',
                220200: '无锡市',
                220300: '徐州市',
                220400: '常州市',
                220500: '苏州市',
                220600: '南通市',
                220700: '连云港市',
                220800: '淮安市',
                220900: '盐城市',
                221000: '扬州市',
                221100: '镇江市',
                221200: '泰州市',
                221300: '宿迁市'
            },
            230000: {
                230100: '杭州市',
                230200: '宁波市',
                230300: '温州市',
                230400: '嘉兴市',
                230500: '湖州市',
                230600: '绍兴市',
                230700: '金华市',
                230800: '衢州市',
                230900: '舟山市',
                231000: '台州市',
                231100: '丽水市'
            },
            240000: {
                240100: '合肥市',
                240200: '芜湖市',
                240300: '蚌埠市',
                240400: '淮南市',
                240500: '马鞍山市',
                240600: '淮北市',
                240700: '铜陵市',
                240800: '安庆市',
                241000: '黄山市',
                241100: '滁州市',
                241200: '阜阳市',
                241300: '宿州市',
                241500: '六安市',
                241600: '亳州市',
                241700: '池州市',
                241800: '宣城市'
            },
            310000: {
                310100: '福州市',
                310200: '厦门市',
                310300: '莆田市',
                310400: '三明市',
                310500: '泉州市',
                310600: '漳州市',
                310700: '南平市',
                310800: '龙岩市',
                310900: '宁德市'
            },
            250000: {
                250100: '南昌市',
                250200: '景德镇市',
                250300: '萍乡市',
                250400: '九江市',
                250500: '新余市',
                250600: '鹰潭市',
                250700: '赣州市',
                250800: '吉安市',
                250900: '宜春市',
                251000: '抚州市',
                251100: '上饶市'
            },
            460000: {
                460100: '济南市',
                460200: '青岛市',
                460300: '淄博市',
                460400: '枣庄市',
                460500: '东营市',
                460600: '烟台市',
                460700: '潍坊市',
                460800: '济宁市',
                460900: '泰安市',
                461000: '威海市',
                461100: '日照市',
                461200: '莱芜市',
                461300: '临沂市',
                461400: '德州市',
                461500: '聊城市',
                461600: '滨州市',
                461700: '菏泽市'
            },
            530000: {
                530100: '郑州市',
                530200: '开封市',
                530300: '洛阳市',
                530400: '平顶山市',
                530500: '安阳市',
                530600: '鹤壁市',
                530700: '新乡市',
                530800: '焦作市',
                530900: '濮阳市',
                531000: '许昌市',
                531100: '漯河市',
                531200: '三门峡市',
                531300: '南阳市',
                531400: '商丘市',
                531500: '信阳市',
                531600: '周口市',
                531700: '驻马店市',
                539001: '济源市'
            },
            510000: {
                510100: '武汉市',
                510200: '黄石市',
                510300: '十堰市',
                510500: '宜昌市',
                510600: '襄阳市',
                510700: '鄂州市',
                510800: '荆门市',
                510900: '孝感市',
                511000: '荆州市',
                511100: '黄冈市',
                511200: '咸宁市',
                511300: '随州市',
                512800: '恩施土家族苗族自治州',
                519004: '仙桃市',
                519005: '潜江市',
                519006: '天门市',
                519021: '神农架林区'
            },
            520000: {
                520100: '长沙市',
                520200: '株洲市',
                520300: '湘潭市',
                520400: '衡阳市',
                520500: '邵阳市',
                520600: '岳阳市',
                520700: '常德市',
                520800: '张家界市',
                520900: '益阳市',
                521000: '郴州市',
                521100: '永州市',
                521200: '怀化市',
                521300: '娄底市',
                523100: '湘西土家族苗族自治州'
            },
            320000: {
                320100: '广州市',
                320200: '韶关市',
                320300: '深圳市',
                320400: '珠海市',
                320500: '汕头市',
                320600: '佛山市',
                320700: '江门市',
                320800: '湛江市',
                320900: '茂名市',
                321200: '肇庆市',
                321300: '惠州市',
                321400: '梅州市',
                321500: '汕尾市',
                321600: '河源市',
                321700: '阳江市',
                321800: '清远市',
                321900: '东莞市',
                322000: '中山市',
                322100: '东沙群岛',
                325100: '潮州市',
                325200: '揭阳市',
                325300: '云浮市'
            },
            330000: {
                330100: '南宁市',
                330200: '柳州市',
                330300: '桂林市',
                330400: '梧州市',
                330500: '北海市',
                330600: '防城港市',
                330700: '钦州市',
                330800: '贵港市',
                330900: '玉林市',
                331000: '百色市',
                331100: '贺州市',
                331200: '河池市',
                331300: '来宾市',
                331400: '崇左市'
            },
            340000: {
                340100: '海口市',
                340200: '三亚市',
                340300: '三沙市',
                340400: '儋州市',
                349001: '五指山市',
                349002: '琼海市',
                349005: '文昌市',
                349006: '万宁市',
                349007: '东方市',
                349021: '定安县',
                349022: '屯昌县',
                349023: '澄迈县',
                349024: '临高县',
                349025: '白沙黎族自治县',
                349026: '昌江黎族自治县',
                349027: '乐东黎族自治县',
                349028: '陵水黎族自治县',
                349029: '保亭黎族苗族自治县',
                349030: '琼中黎族苗族自治县'
            },
            650000: {
                650100: '重庆城区',
                650200: '重庆郊县'
            },
            610000: {
                610100: '成都市',
                610300: '自贡市',
                610400: '攀枝花市',
                610500: '泸州市',
                610600: '德阳市',
                610700: '绵阳市',
                610800: '广元市',
                610900: '遂宁市',
                611000: '内江市',
                611100: '乐山市',
                611300: '南充市',
                611400: '眉山市',
                611500: '宜宾市',
                611600: '广安市',
                611700: '达州市',
                611800: '雅安市',
                611900: '巴中市',
                612000: '资阳市',
                613200: '阿坝藏族羌族自治州',
                613300: '甘孜藏族自治州',
                613400: '凉山彝族自治州'
            },
            620000: {
                620100: '贵阳市',
                620200: '六盘水市',
                620300: '遵义市',
                620400: '安顺市',
                620500: '毕节市',
                620600: '铜仁市',
                622300: '黔西南布依族苗族自治州',
                622600: '黔东南苗族侗族自治州',
                622700: '黔南布依族苗族自治州'
            },
            630000: {
                630100: '昆明市',
                630300: '曲靖市',
                630400: '玉溪市',
                630500: '保山市',
                630600: '昭通市',
                630700: '丽江市',
                630800: '普洱市',
                630900: '临沧市',
                632300: '楚雄彝族自治州',
                632500: '红河哈尼族彝族自治州',
                632600: '文山壮族苗族自治州',
                632800: '西双版纳傣族自治州',
                632900: '大理白族自治州',
                633100: '德宏傣族景颇族自治州',
                633300: '怒江傈僳族自治州',
                633400: '迪庆藏族自治州'
            },
            640000: {
                640100: '拉萨市',
                640200: '日喀则市',
                640300: '昌都市',
                640400: '林芝市',
                640500: '山南市',
                642400: '那曲地区',
                642500: '阿里地区'
            },
            810000: {
                810100: '西安市',
                810200: '铜川市',
                810300: '宝鸡市',
                810400: '咸阳市',
                810500: '渭南市',
                810600: '延安市',
                810700: '汉中市',
                810800: '榆林市',
                810900: '安康市',
                811000: '商洛市'
            },
            820000: {
                820100: '兰州市',
                820200: '嘉峪关市',
                820300: '金昌市',
                820400: '白银市',
                820500: '天水市',
                820600: '武威市',
                820700: '张掖市',
                820800: '平凉市',
                820900: '酒泉市',
                821000: '庆阳市',
                821100: '定西市',
                821200: '陇南市',
                822900: '临夏回族自治州',
                823000: '甘南藏族自治州'
            },
            830000: {
                830100: '西宁市',
                830200: '海东市',
                832200: '海北藏族自治州',
                832300: '黄南藏族自治州',
                832500: '海南藏族自治州',
                832600: '果洛藏族自治州',
                832700: '玉树藏族自治州',
                832800: '海西蒙古族藏族自治州'
            },
            840000: {
                840100: '银川市',
                840200: '石嘴山市',
                840300: '吴忠市',
                840400: '固原市',
                840500: '中卫市'
            },
            850000: {
                850100: '乌鲁木齐市',
                850200: '克拉玛依市',
                850400: '吐鲁番市',
                850500: '哈密市',
                852300: '昌吉回族自治州',
                852700: '博尔塔拉蒙古自治州',
                852800: '巴音郭楞蒙古自治州',
                852900: '阿克苏地区',
                853000: '克孜勒苏柯尔克孜自治州',
                853100: '喀什地区',
                853200: '和田地区',
                854000: '伊犁哈萨克自治州',
                854200: '塔城地区',
                854300: '阿勒泰地区',
                859001: '石河子市',
                859002: '阿拉尔市',
                859003: '图木舒克市',
                859004: '五家渠市',
                859005: '北屯市',
                859006: '铁门关市',
                859007: '双河市',
                859008: '可克达拉市',
                859009: '昆玉市'
            },
            910000: {
                910100: '香港城区'
            },
            920000: {
                820100: '澳门城区'
            },
            930000: {
                930100: '台湾'
            }
        }
    ;

    if (typeof window !== 'undefined') {
        window.ChineseDistricts = ChineseDistricts;
    }

    return ChineseDistricts;

});
