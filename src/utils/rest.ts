/* eslint-disable @typescript-eslint/no-explicit-any */
// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
const getParams = (queryParams: any) => {
  const { id = 0 } = queryParams;

  const filter = {
    id: parseInt(id),
  };

  return { ...filter };
};

export { getParams };
