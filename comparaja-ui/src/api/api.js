export const getProducts = () => {
  const endPoint = process.env.REACT_APP_SERVICE_ENPOINT;
  const apiKey = process.env.REACT_APP_API_KEY;
  const url = `${endPoint}/product?api_key=${apiKey}`;
  return fetch(url);
};
