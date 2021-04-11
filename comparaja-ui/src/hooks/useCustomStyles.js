import { makeStyles } from "@material-ui/core/styles";

const useCustomStyles = () => {
  const useStyles = makeStyles((theme) => {
    const hexToRgb = (hex) => {
      const result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
      return `${parseInt(result[1], 16)}, ${parseInt(
        result[2],
        16
      )}, ${parseInt(result[3], 16)}`;
    };
    const customBorder = theme.spacing(4);
    return {
      avatar: {
        width: theme.spacing(18),
        height: theme.spacing(6),
      },
      container: {
        padding: theme.spacing(2),
      },
      card: {
        background: `rgba(${hexToRgb(theme.palette.grey[50])}, .7)`,
        borderRadius: customBorder,
      },
      cardSponsored: {
        borderRadius: customBorder,
        height: "100%",
        width: "100%",
        background: `linear-gradient(-45deg, rgba(${hexToRgb(
          "#ee7752"
        )}, .7), rgba(${hexToRgb("#e73c7e")}, .7), rgba(${hexToRgb(
          "#23a6d5"
        )}, .7), rgba(${hexToRgb("#23d5ab")}, .7))`,
        backgroundSize: "400% 400%",
        animation: "gradient 7s ease infinite",
      },
      fab: {
        width: "inherit",
        backgroundColor: "white",
      },
      fabSponsored: {
        width: "inherit",
        backgroundColor: "white",
        background: `linear-gradient(-45deg, rgba(${hexToRgb(
          "#E6B859"
        )}, .4), rgba(${hexToRgb("FCDB4D")}, .2), rgba(${hexToRgb(
          "#E6B859"
        )}, .5), rgba(${hexToRgb("#FCDB4D")}, .3))`,
        backgroundSize: "400% 400%",
        animation: "gradient 8s ease infinite",
      },
      list: {
        padding: theme.spacing(2),
      },
      listHeader: {
        paddingBottom: theme.spacing(4),
      },
      listContent: {
        borderRadius: customBorder,
      },
      listItem: {
        justifyContent: "center",
        backgroundColor: `rgba(255, 255, 255, .65)`,
      },
      paper: {
        backgroundColor: "rgba(0, 0, 0, 0)",
        borderRadius: customBorder,
      },
      paperSponsored: {
        backgroundColor: "rgba(0, 0, 0, 0)",
        borderRadius: customBorder,
        border: "solid",
        borderColor: "gold",
        animation: "spin 3.5s linear infinite",        
      },
      "@global": {
        "@keyframes gradient": {
          "0%": {
            backgroundPosition: "0% 50%",
          },
          "50%": {
            backgroundPosition: "100% 50%",
          },
          "100%": {
            backgroundPosition: "0% 50%",
          },
        },
        "@keyframes spin": {
          "91%": {
            transform: "rotateZ(0deg)",
          },
          "92%": {
            transform: "rotateZ(1eg)",
          },
          "93%": {
            transform: "rotateZ(5deg)",
          },
          "95%": {
            transform: "rotateZ(20deg)",
          },
          "96%": {
            transform: "rotateZ(-20deg)",
          },
          "97%": {
            transform: "rotateZ(5deg)",
          },
          "98%": {
            transform: "rotateZ(-5deg)",
          },
          "99%": {
            transform: "rotateZ(1deg)",
          },
          "100%": {
            transform: "rotateZ(-1deg)",
          },
        },
      },
    };
  });
  return useStyles();
};

export default useCustomStyles;
