import axios from "axios";

export default axios.create({
  baseURL: "http://tutorials2025ines.us-east-1.elasticbeanstalk.com/api/v1",
  headers: {
    "Content-type": "application/json"
  }
});