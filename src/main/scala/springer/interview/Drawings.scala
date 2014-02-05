package springer.interview

object Drawings {
  type Canvas = List[List[Char]]

  def rectangleDrawing(xStart: Int, yStart: Int, xEnd: Int, yEnd: Int): Canvas => Canvas = {
    _.zipWithIndex.map {
      case (row, rowIndex) if rowIndex == yStart || rowIndex == yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex >= xStart && cellIndex <= xEnd) 'x' else cell
        }
      }
      case (row, rowIndex) if rowIndex > yStart && rowIndex < yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex == xStart || cellIndex == xEnd) 'x' else cell
        }
      }
      case (row, _) => row
    }
  }

  def lineDrawing(xStart: Int, yStart: Int, xEnd: Int, yEnd: Int): Canvas => Canvas = {
    canvas =>
      canvas.zipWithIndex.map {
        case (row, rowIndex) if rowIndex >= yStart && rowIndex > 0 && rowIndex <= yEnd && rowIndex < canvas.size - 1 => {
          row.zipWithIndex map {
            case (cell, cellIndex) => if (cellIndex >= xStart && cellIndex <= xEnd && cellIndex > 0) 'x' else cell
          }
        }
        case (row, _) => row
      }
  }

  def bucketFill(xAxis: Int, yAxis: Int, color: Char): Canvas => Canvas = {

    def alreadyBucketFilled(canvas: Canvas, xAxis: Int, yAxis: Int) = canvas(yAxis)(xAxis) == color
    def alreadyPainted(canvas: Canvas, xAxis: Int, yAxis: Int) = canvas(yAxis)(xAxis) == 'x'
    def outSidePaintableCanvasArea(canvas: Canvas, xAxis: Int, yAxis: Int) = xAxis < 1 || xAxis > canvas(0).size - 2 || yAxis < 1 || yAxis > canvas.size - 2

    canvas =>
      if (alreadyBucketFilled(canvas, xAxis, yAxis))
        canvas
      else if (alreadyPainted(canvas: Canvas, xAxis: Int, yAxis: Int))
        canvas
      else if (outSidePaintableCanvasArea(canvas, xAxis, yAxis)) {
        canvas
      } else {
        def drawCanvas(xAxis: Int, yAxis: Int, color: Char): Canvas => Canvas = {
          _.zipWithIndex.map {
            case (row, rowIndex) => {
              row.zipWithIndex.map {
                case (cell, columnIndex) => {
                  if (rowIndex == yAxis && columnIndex == xAxis && cell != color && cell != 'x') color
                  else cell
                }
              }
            }
          }
        }
        List((xAxis, yAxis, color),
          (xAxis + 1, yAxis, color),
          (xAxis, yAxis + 1, color),
          (xAxis - 1, yAxis, color),
          (xAxis, yAxis - 1, color)
        ).foldLeft(drawCanvas(xAxis, yAxis, color)(canvas)) {
          (canvas, step) => bucketFill(step._1, step._2, step._3)(canvas)
        }
      }
  }

  def canvasDrawing(xAxis: Int, yAxis: Int): Canvas => Canvas = {
    _ => {
      val numberOfRows = yAxis + 2
      val numberOfColumns = xAxis + 2

      (0 until numberOfRows).map {
        case x if x == 0 || x == numberOfRows - 1 => 0.until(numberOfColumns).map(_ => '-').toList
        case _ => 0.until(numberOfColumns).map {
          case x if x == 0 || x == numberOfColumns - 1 => '|'
          case _ => ' '
        }.toList
      }.toList
    }
  }
}

