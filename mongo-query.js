db.collection.aggregate([
  {
    /**Filtering for task requirements*/
    $match: {
      $or: [
        {
          $and: [
            {
              questionId: {
                $eq: "1"
              }
            },
            {
              answeredIndex: {
                $eq: 1
              }
            }
          ]
        },
        {
          $and: [
            {
              questionId: {
                $eq: "2"
              }
            },
            {
              answeredIndex: {
                $eq: 0
              }
            }
          ]
        }
      ]
    }
  },
  /**Counting how many times the same user appears*/
  {
    $group: {
      _id: {
        userId: "$userId"
      },
      count: {
        $sum: 1
      }
    }
  },
  /**Counting only userIds that appears 2 times (it means both requirements are meet) )*/
  {
    $match: {
      count: {
        $eq: 2
      }
    }
  },
  /**Showing the final result*/
  {
    $count: "result"
  }
])
