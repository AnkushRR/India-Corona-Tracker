package in.ankushrodewad.coronaindia;

public class CountryStatus {
    private String country_name, total_cases, new_cases, total_deaths, new_deaths, recovered, active, critical, cases_per_million_pop;

    public CountryStatus(String country_name, String total_cases, String new_cases, String total_deaths, String new_deaths, String recovered, String active, String critical, String cases_per_million_pop) {
        this.country_name = country_name;
        this.total_cases = total_cases;
        this.new_cases = new_cases;
        this.total_deaths = total_deaths;
        this.new_deaths = new_deaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.cases_per_million_pop = cases_per_million_pop;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(String total_cases) {
        this.total_cases = total_cases;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public String getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(String total_deaths) {
        this.total_deaths = total_deaths;
    }

    public String getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(String new_deaths) {
        this.new_deaths = new_deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getCases_per_million_pop() {
        return cases_per_million_pop;
    }

    public void setCases_per_million_pop(String cases_per_million_pop) {
        this.cases_per_million_pop = cases_per_million_pop;
    }
}
