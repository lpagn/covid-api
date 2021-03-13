echo "API test"

print_line(){
  echo ""
  echo "=========================================="
  echo ""
}

prov_id(){
  print_line
  GETPROVID="getProvinceId/"$1
  echo $BASE_URL$GETPROVID
  curl $BASE_URL$GETPROVID
}

print_line

BASE_URL="localhost:8080/api/main/"
echo $BASE_URL
curl $BASE_URL

print_line

SAMPLE="sample"

echo $BASE_URL$SAMPLE
curl $BASE_URL$SAMPLE

print_line

DEATHS="deaths"

echo $BASE_URL$DEATHS
curl $BASE_URL$DEATHS

print_line

DEATHSPROV="deaths/Buenos%20Aires"

echo $BASE_URL$DEATHSPROV
curl $BASE_URL$DEATHSPROV

print_line

CASES="cases"

echo $BASE_URL$CASES
curl $BASE_URL$CASES

print_line

CASESPROV="cases/Buenos%20Aires"

echo $BASE_URL$CASESPROV
curl $BASE_URL$CASESPROV

print_line


LAST_UPDATE="lastUpdate"

echo $BASE_URL$LAST_UPDATE
curl $BASE_URL$LAST_UPDATE

print_line

DEATHS_BY_DAY="deathsByDay/7"

echo $BASE_URL$DEATHS_BY_DAY
curl $BASE_URL$DEATHS_BY_DAY

print_line

PANDEMIC_LENGTH="pandemicLength"

echo $BASE_URL$PANDEMIC_LENGTH
curl $BASE_URL$PANDEMIC_LENGTH

prov_id "Buenos%20Aires"
prov_id "Tucum%C3%A1n"
prov_id "Neuqu%C3%A9n"
prov_id "C%C3%B3rdoba"
prov_id "R%C3%ADo%20Negro"