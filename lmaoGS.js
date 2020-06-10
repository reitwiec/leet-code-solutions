var response = {
    "2020-04-16T18:38:00.000+8886": [
        {
            "client_id": "126CB3AC2944478F979921FE1010756A",

            "currency": "USD",

            "above_threshold": 3,

            "total_tx": 11,

            "date": "2020-04-16",
        }],

    "2020-04-18T18:38:88.008+9808": [
        {
            "client_id": "81984C1889AB4AD8B8FEE56E85C72485",

            "currency": "EUR",

            "above_threshold": 34,

            "total_tx": 328,

            "date": "2020-04-18"
        },
        {
            "client_id": "81984C1889AB4AD8B8FEE56E85C72485",

            "currency": "GBP",

            "above_threshold": 3,

            "total_tx": 328,

            "date": "2020-04-18"
        },
        {

            "client_id": "81984C1889AB4AD8B8FEE56E85C72485",

            "currency": "JPY",

            "above_threshold": 5,

            "total_tx": 328,

            "date": "2020-04-18"
        },
        {

            "client_id": "61984C1889AB4ADSBAFEE56E85c72485",

            "currency": "USD",

            "above_threshold": 22,

            "total_tx": 320,

            "date": "2020-04-18"
        }
    ]
}
var dateKeys = Object.keys(response);

var dateWise = [];
var mockData = {};
var totalAboveThresholdCount = 0;
var totalTxInRange = 0;
dateKeys.forEach(date => {
    var content = response[date];
    var obj = {};
    var date_YY_MM_DD = content[0]["date"];
    var temp = date_YY_MM_DD.split("-");
    temp.reverse();
    obj["date"] = temp.join("-");
    obj["client_data"] = {};
    var aboveThresholdCount = 0;
    var totalTxInADay = 0;
    content.forEach(detail => {
        if (detail["client_id"] in obj["client_data"]) { //detail are the objects in date array
            //client already exists in the object
            obj["client_data"][detail["client_id"]]["currency_split"][detail["currency"]] = detail["above_threshold"]
            aboveThresholdCount += detail["above_threshold"];

        } else {
            //insert new client in client data
            obj["client_data"][detail["client_id"]] = {}; // created a new key for a particular client
            obj["client_data"][detail["client_id"]]["currency_split"] = {}; // new currency split
            obj["client_data"][detail["client_id"]]["currency_split"][detail["currency"]] = detail["above_threshold"]
            obj["client_data"][detail["client_id"]]["total_tx"] = detail["total_tx"];
            aboveThresholdCount += detail["above_threshold"];
            totalTxInADay += detail["total_tx"];
        }
    })

    obj["above_threshold_count"] = aboveThresholdCount;
    obj["total_tx_in_day"] = totalTxInADay;
    totalAboveThresholdCount += aboveThresholdCount;
    totalTxInRange += totalTxInADay;
    dateWise.push(obj);
})
mockData["date_wise"] = dateWise;
mockData["total_above_threshold_count"] = totalAboveThresholdCount;
mockData["total_tx_in_range"] = totalTxInRange;
