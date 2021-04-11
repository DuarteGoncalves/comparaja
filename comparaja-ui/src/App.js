import {
  Avatar,
  Card,
  CardContent,
  Container,
  Grid,
  Fab,
  List,
  ListItem,
  ListItemText,
  Tooltip,
  Paper,
} from "@material-ui/core";
import BrokenImageIcon from "@material-ui/icons/BrokenImage";
import { useEffect, useState } from "react";
import { getProducts } from "./api/api";
import useCustomStyles from "./hooks/useCustomStyles";

const App = () => {
  const classes = useCustomStyles();
  const [products, setProducts] = useState([]);

  useEffect(() => {
    getProducts()
      .then((response) => response.json().then((data) => setProducts(data)))
      .catch((error) => {
        setProducts([]);
        console.error(error);
      });
  }, []);

  return (
    <Container spacing={2} className={classes.container}>
      <Grid
        container
        direction="row"
        justify="center"
        alignItems="center"
        spacing={2}
      >
        {products.map((product) => {
          return (
            <Grid item>
              <Paper
                elevation={4}
                className={
                  product.isSponsored ? classes.paperSponsored : classes.paper
                }
              >
                <Card
                  className={
                    product.isSponsored ? classes.cardSponsored : classes.card
                  }
                >
                  <CardContent>
                    <List className={classes.list}>
                      <ListItem
                        alignItems="center"
                        className={classes.listHeader}
                      >
                        <Tooltip title={product.providerName} placement="top">
                          <Fab
                            variant="extended"
                            className={
                              product.isSponsored
                                ? classes.fabSponsored
                                : classes.fab
                            }
                          >
                            {product.providerLogoURL ? (
                              <Avatar
                                className={classes.avatar}
                                src={product.providerLogoURL}
                                variant="rounded"
                              />
                            ) : (
                              <BrokenImageIcon color="primary" />
                            )}
                          </Fab>
                        </Tooltip>
                      </ListItem>
                      <div className={classes.listContent}>
                        {Object.entries(product.data)
                          .filter(([key]) => key !== "p")
                          .map(([key, value]) => {
                            const label =
                              key.charAt(0).toUpperCase() +
                              key.slice(1).replaceAll("_", " ");
                            return (
                              <ListItem
                                key={key}
                                className={classes.listItem}
                                button
                              >
                                <ListItemText
                                  primary={label}
                                  secondary={value ?? "-"}
                                />
                              </ListItem>
                            );
                          })}
                      </div>
                    </List>
                  </CardContent>
                </Card>
              </Paper>
            </Grid>
          );
        })}
      </Grid>
    </Container>
  );
};

export default App;
